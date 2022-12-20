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
import com.jslhrd.utility.PageDto;

@WebServlet("/notice.do")
public class Notice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Notice() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		NoticeDao dao = NoticeDao.getInstance();
		
		Criteria cri = new Criteria();
		
		if(request.getParameter("p") != null) {
			cri.setPageNum(Integer.parseInt(request.getParameter("p")));
		}
		if(request.getParameter("amount") != null) {
			cri.setAmount(Integer.parseInt(request.getParameter("amount")));
		}
				
		int count = dao.noticeSize();
		PageDto pdto = new PageDto(cri, count);
		
		request.setAttribute("pagemaker", pdto);
		request.setAttribute("count", count);
		// request.setAttribute("noticelist", dao.noticeSelectAll());
		request.setAttribute("noticelist", dao.getListWithPaging(cri));
		
		RequestDispatcher rd = request.getRequestDispatcher("/notice/notice.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
