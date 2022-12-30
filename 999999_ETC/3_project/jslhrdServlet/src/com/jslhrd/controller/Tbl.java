package com.jslhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tbl.do")
public class Tbl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Tbl() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String url = "/qna/qa.jsp";
    	// 임시방편. 장래에는 tbl.jsp에 속성을 포워딩해서 거기에서 뭔가 해야 한다.
    	if(request.getParameter("t") != null) {
    		if(request.getParameter("t").equals("notice")) {
    			url = "/notice/notice.jsp";
    		} else if(request.getParameter("t").equals("faq")) {
    			url = "/faq/faq.jsp";
    		} else if(request.getParameter("t").equals("portfolio")) {
    			url = "/portfolio/portfolio.jsp";
    		}
    	}
    	
    	
    	
    	RequestDispatcher rd = request.getRequestDispatcher(url);
    	rd.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
