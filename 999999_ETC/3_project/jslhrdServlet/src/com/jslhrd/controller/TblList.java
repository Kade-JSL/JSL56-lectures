package com.jslhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.controller.notice.Notice;
import com.jslhrd.controller.portfolio.Portfolio;
import com.jslhrd.controller.qna.Qa;

@WebServlet("/tbl.do")
public class TblList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TblList() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "/index.jsp";
		String tblType = "";
		JSLServletController tblMenu = null;
		
		// 임시방편. 장래에는 tbl.jsp에 속성을 포워딩해서 거기에서 뭔가 해야 한다.
		if (request.getParameter("t") != null) {
			if (request.getParameter("t").equals("notice")) {
				url = "/notice/notice.jsp";
				tblType = "notice";
				tblMenu = new Notice(request, response);
			} else if (request.getParameter("t").equals("faq")) {
				url = "/faq/faq.jsp";
				tblType = "faq";
			} else if (request.getParameter("t").equals("port")) {
				url = "/portfolio/portfolio.jsp";
				tblType = "port";
				tblMenu = new Portfolio(request, response);
			} else if (request.getParameter("t").equals("qa")) {
				url = "/qna/qa.jsp";
				tblType = "qa";
				tblMenu = new Qa(request, response);
			}
			tblMenu.doGetList();
		}

		request.setAttribute("tbltype", tblType);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}