package com.jslhrd.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.dao.MemberDao;

@WebServlet("/memberidcheck.do")
public class MemberIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberIdCheck() {
        super();
    }

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		int result = MemberDao.getInstance().selectId(id);
		response.setContentType("text/html, charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.close();
	}

}
