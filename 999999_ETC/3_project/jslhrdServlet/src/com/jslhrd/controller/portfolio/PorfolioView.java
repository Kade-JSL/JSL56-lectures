package com.jslhrd.controller.portfolio;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.dao.PortfolioDao;
import com.jslhrd.utility.Criteria;
import com.jslhrd.utility.PageDto;

@WebServlet(urlPatterns = {"/portview.do", "/adm-port-view.do"})
public class PorfolioView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PorfolioView() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int p = 1, a = 5;
		String paramP = request.getParameter("p");
		String paramA = request.getParameter("a");
		if (paramP != null) { p = Integer.parseInt(paramP); }
		if (paramA != null) { a = Integer.parseInt(paramA); }
		
		PortfolioDao dao = PortfolioDao.getInstance();
		PageDto pagemaker = new PageDto(new Criteria(p, a), dao.portCount());
		
		int n = Integer.parseInt(request.getParameter("n"));
		Map<String, Object> dto = dao.readPortContent(n);
		
		request.setAttribute("pagemaker", pagemaker);
		request.setAttribute("view", dto);
		
		String command = request.getServletPath();
		String path = "";
		if (command.equals("/portview.do")) {
			path = "/portfolio/portfolioview.jsp";
		} else if (command.equals("/adm-port-view.do")) {
			path = "/adm/port/portview.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
