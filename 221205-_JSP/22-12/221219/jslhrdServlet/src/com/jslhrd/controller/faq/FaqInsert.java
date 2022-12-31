package com.jslhrd.controller.faq;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.dao.FaqDao;
import com.jslhrd.dto.FaqDto;

@WebServlet("/faqinsert.do")
public class FaqInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	public FaqInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/faq/faqWrite.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		FaqDto dto = new FaqDto();
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		FaqDao.getInstance().insertFaq(dto);
		
		response.sendRedirect("/faq.do");
	}

}
