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

@WebServlet("/view.do")
public class TblView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TblView() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String url = "/index.jsp";
		String tblType = "";
		JSLServletController con = null;
		if (request.getParameter("t") != null) {
			tblType = request.getParameter("t");
			if (tblType.equals("port")) {
				url = "/portfolio/portfolioview.jsp";
				con = new Portfolio(request, response);
			} else if (tblType.equals("notice")) {
				url = "/notice/noticeView.jsp";
				con = new Notice(request, response);
			}
			con.doGetView();
		}
		
		request.setAttribute("tbltype", tblType);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
