package com.jslhrd.controller.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.dao.NoticeDao;
import com.jslhrd.utility.Criteria;

/**
 * Servlet implementation class NoticeView
 */
@WebServlet(urlPatterns = {"/noticeview.do", "/adm-notice-view.do"})
public class NoticeView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int bno = Integer.parseInt(request.getParameter("n"));
		
		NoticeDao dao = NoticeDao.getInstance();
		dao.viewCount(bno);
		
		int p = Integer.parseInt(request.getParameter("p"));
		int a = Integer.parseInt(request.getParameter("a"));
		
		Criteria cri = new Criteria(p, a);
		
		request.setAttribute("cri", cri);
		request.setAttribute("prev", dao.prevBno(bno));
		request.setAttribute("view", dao.selectBno(bno));
		request.setAttribute("next", dao.nextBno(bno));
		
		String command = request.getServletPath();
		String path = "/main.do";
		
		if (command.equals("/noticeview.do")) {
			path = "/notice/noticeview.jsp";
		} else if (command.equals("/adm-notice-view.do")) {
			path = "/adm/notice/noticeview.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
