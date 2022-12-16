package com.jslhrd.controller.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.dao.NoticeDao;
import com.jslhrd.dto.NoticeDto;

@WebServlet("/notice.do")
public class Notice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Notice() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<NoticeDto> noticeList = NoticeDao.getInstance().noticeSelectAll();
		
		request.setAttribute("noticelist", noticeList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/notice/notice.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
