package com.jslhrd.controller.faq;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.dao.FaqDao;
import com.jslhrd.dto.FaqDto;

/**
 * Servlet implementation class Faq
 */
@WebServlet("/faq.do")
public class Faq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Faq() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FaqDto> dtoList = FaqDao.getInstance().selectAllFaq();
		request.setAttribute("faqlist", dtoList);
		RequestDispatcher rd = request.getRequestDispatcher("/faq/faq.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
