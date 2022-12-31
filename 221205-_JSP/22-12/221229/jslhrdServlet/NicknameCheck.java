package com.jslhrd.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.dao.MemberDao;

@WebServlet("/nicknamecheck.do")
public class NicknameCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NicknameCheck() {
        super();
    }

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response);
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String nickname = request.getParameter("nickname");
		int result = MemberDao.getInstance().selectNickname(nickname);
		response.setContentType("text/html, charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.close();
	}

}
