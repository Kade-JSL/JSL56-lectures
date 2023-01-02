package com.jslhrd.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;


@WebServlet("/authcheck.do")
public class AuthCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AuthCheck() {
        super();
    }

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}


	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String authNumber = request.getParameter("authnumber");
		String authKey = (String) request.getSession().getAttribute("authkey");
		JSONObject obj = new JSONObject();
		
		if (authNumber.equals(authKey)) {
			obj.put("msg", "인증번호가 일치합니다.");
			obj.put("check", "ok");
		} else {
			obj.put("msg", "인증번호가 일치하지 않습니다.");
			obj.put("check", "no");
		}
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/x-json, charset=UTF-8");
		response.getWriter().print(obj);
	}

}
