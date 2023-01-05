package com.jslhrd.controller.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.dao.NoticeDao;
import com.jslhrd.dto.NoticeDto;
import com.jslhrd.utility.Criteria;

@WebServlet("/adm-notice-modify.do")
public class NoticeModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeModify() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		NoticeDto dto = NoticeDao.getInstance().selectBno(Integer.parseInt(request.getParameter("bno")));
		dto.setContent(dto.getContent().replace("<br>", "\r\n"));
		int p = Integer.parseInt(request.getParameter("p"));
		int a = Integer.parseInt(request.getParameter("a"));
		request.setAttribute("cri", new Criteria(p, a));
		request.setAttribute("modify", dto);
		RequestDispatcher rd = request.getRequestDispatcher("adm/notice/noticemodify.jsp");
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		NoticeDto dto = new NoticeDto();
		
		dto.setBno(Integer.parseInt(request.getParameter("bno")));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		
		NoticeDao.getInstance().noticeUpdate(dto);
		
		String fwd = "/adm-notice-view.do?n=" + dto.getBno() + "&p=" + request.getParameter("p") + "&a="+ request.getParameter("a");
		response.sendRedirect(fwd);
	}

}
