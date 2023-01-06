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

@WebServlet("/adm-notice-write.do")
public class NoticeWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public NoticeWrite() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/adm/notice/noticewrite.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		NoticeDto dto = new NoticeDto();
		
		dto.setWriter(request.getParameter("writer"));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		
		NoticeDao dao = NoticeDao.getInstance();
		dao.noticeInsert(dto);
		
		response.sendRedirect("adm-notice.do");
	}

}
