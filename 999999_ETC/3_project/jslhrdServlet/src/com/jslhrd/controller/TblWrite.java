package com.jslhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.controller.portfolio.Portfolio;

@WebServlet("/write.do")
public class TblWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TblWrite() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "index.jsp";
		String tblType = "";
		if (request.getParameter("t") != null) {
			if (request.getParameter("t").equals("qa")) {
				url = "/qna/write.jsp";
				tblType = "qa";
			} else if (request.getParameter("t").equals("port")) {
				url = "/portfolio/write.jsp";
				tblType = "port";
			}
		}
		
		request.setAttribute("tbltype", tblType);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String tblType = "notice";
		JSLServletController con = null;
		if(request.getParameter("t") != null) {
			tblType = request.getParameter("t");
			if (tblType.equals("port")) {
				
			}
		}
		
		response.sendRedirect("tbl.do?t=" + tblType);
	}

}
