package com.jslhrd.controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.dao.MemberDao;
import com.jslhrd.utility.SHA256;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/login/login.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = SHA256.encode(request.getParameter("pw"));
		switch(MemberDao.getInstance().memberIdPwCheck(id, pw)) {
			case 1:
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				response.sendRedirect("main.do");
				break;
			case 0:	case -1:
				request.setAttribute("msg", "아이디 또는 비밀번호를 확인하세요.");
				RequestDispatcher rd = request.getRequestDispatcher("/login/login.jsp");
				rd.forward(request, response);
				break;
		}
	}

}
