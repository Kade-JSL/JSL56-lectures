package com.jslhrd.controller.portfolio;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.dao.PortfolioDao;
import com.jslhrd.dto.PortfolioDto;
import com.jslhrd.utility.Criteria;
import com.jslhrd.utility.PageDto;

@WebServlet("/portfolio.do")
public class Portfolio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Portfolio() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PortfolioDao pdao = PortfolioDao.getInstance();
		int pageNum = 1, amount = 5;
		if (request.getParameter("p") != null) { pageNum = Integer.parseInt(request.getParameter("p")); }
		if (request.getParameter("a") != null) { amount = Integer.parseInt(request.getParameter("a")); }
		
		Criteria cri = new Criteria(pageNum, amount);
		PageDto pdto = new PageDto(cri, pdao.portCount());
		List<PortfolioDto> list = pdao.readPortList(cri);
				
		request.setAttribute("pagemaker", pdto);
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/portfolio/portfolio.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
