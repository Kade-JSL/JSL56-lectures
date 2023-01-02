package com.jslhrd.controller.member;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

@WebServlet("/sendemail.do")
public class SendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SendEmail() {
        super();
    }


//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 국룰
		
		String email = request.getParameter("email");
		
		String host = "smtp.naver.com";
		String user = "cucupapin@naver.com";
		String password = "오류나면 여기 확인";
		
		Properties props = new Properties(); // HashTable을 상속받아 구현한 컬렉션의 한 종류. 키와 값이 String밖에 안 된다.
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		// 네이버에서 사용하는 설정들을 보내 줘야 한다
		
		StringBuffer temp = new StringBuffer(); // 문자열만 저장되는 일종의 배열
		
		SecureRandom rnd = new SecureRandom(); // 
		
		for(int i = 0; i < 10; i++) {
			int rindex = rnd.nextInt(3); // 3보다 작은 무작위의 int: 0, 1, 2
			switch(rindex) {
			case 0:
				// 알파벳 a-z까지의 임의의 문자를 만든다
				temp.append((char) (rnd.nextInt(26) + 97));
				break;
			case 1:
				// A-Z
				temp.append((char) (rnd.nextInt(26) + 65));
				break;
			case 2:
				// 0-9
				temp.append(rnd.nextInt(10));
				break;
			}
		}
		
		String authKey = temp.toString();
						
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			// 사용자를 인증하고 메시지 저장과 전송에 대한 접근권한을 제어한다
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(user, password);
			}
		});
		
		/* 이메일 전송 */
		try {
			MimeMessage msg = new MimeMessage(session);
			// 메시지 제목, 수신자의 이메일 주소, 발송자의 이메일 주소, 보낸 날짜와 같은
			// 실제 이메일 메시지의 세부사항을 나타낸다
			msg.setFrom(new InternetAddress(user, "JSLHRD"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			
			msg.setSubject("JSLシステムからの認証メール");
			msg.setText("아래의 인증번호를 복사하여 인증번호 확인란에 붙여넣어 주세요: \n" + authKey);
			
			Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(temp);
		}
		
		HttpSession sessionKey = request.getSession();
		sessionKey.setAttribute("authkey", authKey); // 세션이 끝날 때까진 유지
		
		JSONObject obj = new JSONObject();
		
		obj.put("msg", "메일 전송 완료.");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/x-json, charset=UTF-8");
		response.getWriter().print(obj);
	}

}
