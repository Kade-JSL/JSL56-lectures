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

@WebServlet(urlPatterns = { "/portfolio.do", "/adm-port.do" })
public class PortfolioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PortfolioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PortfolioDao pageDao = PortfolioDao.getInstance();
		int pageNum = 1, amount = 5;
		if (request.getParameter("p") != null) {
			pageNum = Integer.parseInt(request.getParameter("p"));
		}
		if (request.getParameter("a") != null) {
			amount = Integer.parseInt(request.getParameter("a"));
		}

		Criteria cri = new Criteria(pageNum, amount);
		PageDto pageDto = new PageDto(cri, pageDao.portCount());
		List<PortfolioDto> tblList = pageDao.readPortList(cri);

		request.setAttribute("pagemaker", pageDto);
		request.setAttribute("list", tblList);
		String command = request.getServletPath(), path = "";
		if (command.equals("/portfolio.do")) {
			path = "/portfolio/portfolio.jsp";
		} else if (command.equals("/adm-port.do")) {
			path = "/adm/port/port.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
