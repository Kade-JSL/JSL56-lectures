package com.jslhrd.controller.portfolio;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.controller.notice.SummerNoteServlet;
import com.jslhrd.dao.PortfolioDao;
import com.jslhrd.utility.Criteria;

@WebServlet("/adm-port-mod.do")
public class PortfolioModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PortfolioModify() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		PortfolioDao dao = PortfolioDao.getInstance();
		
		int n = Integer.parseInt(request.getParameter("n")),
		    p = Integer.parseInt(request.getParameter("p")),
		    a = Integer.parseInt(request.getParameter("a"));
		
		request.setAttribute("cri", new Criteria(p, a));
		
		Map<String, Object> map = dao.readPortContent(n);
		request.setAttribute("modify", map);
		
		request.getRequestDispatcher("/adm/port/portmod.jsp").forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Map<String, Object> map = new HashMap<String, Object>();
		int bno = Integer.parseInt(request.getParameter("bno"));
		String title = request.getParameter("title"),
				content = request.getParameter("content"),
				imgurl = SummerNoteServlet.getImgurl();
		
		map.put("bno", bno);
		map.put("title", title);
		map.put("content", content);
		map.put("imgurl", imgurl);
		
		PortfolioDao.getInstance().updatePort(map);
		
		int p = Integer.parseInt(request.getParameter("p")),
				a = Integer.parseInt(request.getParameter("a"));
		response.sendRedirect("/adm-port-view.do?n=" + bno + "&p=" + p + "&a=" + a);
		SummerNoteServlet.setImgurl("");
	}

}
