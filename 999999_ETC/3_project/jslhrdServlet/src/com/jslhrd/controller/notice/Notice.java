package com.jslhrd.controller.notice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.controller.JSLServletController;
import com.jslhrd.dao.NoticeDao;
import com.jslhrd.utility.Criteria;
import com.jslhrd.utility.PageDto;

public class Notice extends JSLServletController {

	public Notice(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}

	@Override
	public void doGetList() throws IOException {
		request.setCharacterEncoding("UTF-8");

		NoticeDao dao = NoticeDao.getInstance();

		Criteria cri = new Criteria();

		if (request.getParameter("p") != null) {
			cri.setPageNum(Integer.parseInt(request.getParameter("p")));
		}
		if (request.getParameter("a") != null) {
			cri.setAmount(Integer.parseInt(request.getParameter("a")));
		}
		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");
		String condition = "";
		if (type != null && !type.equals("")) {
			if (keyword != null) {
				condition = type.toUpperCase() + " LIKE '%" + keyword + "%' AND ";
			}
		}
		cri.setCondition(condition);

		int count = dao.noticeSize(cri);
		PageDto pdto = new PageDto(cri, count);

		request.setAttribute("pagemaker", pdto);
		request.setAttribute("count", count);
		// request.setAttribute("noticelist", dao.noticeSelectAll());
		// request.setAttribute("noticelist", dao.getListWithPaging(cri));
		request.setAttribute("noticelist", dao.searchNoticePageMap(cri));
	}
	
	@Override
	public void doGetView() throws IOException {
		int bno = Integer.parseInt(request.getParameter("n"));
		
		NoticeDao dao = NoticeDao.getInstance();
		dao.viewCount(bno);
		
		int p = 1, a = 10;
		String pageParam = request.getParameter("p");
		String amountParam = request.getParameter("a");
		if (pageParam != null) { p = Integer.parseInt(pageParam); }
		if (amountParam != null) { a = Integer.parseInt(amountParam); }
		
		Criteria cri = new Criteria(p, a);
		
		request.setAttribute("cri", cri);
		request.setAttribute("prev", dao.prevBno(bno));
		request.setAttribute("view", dao.selectBno(bno));
		request.setAttribute("next", dao.nextBno(bno));
	}
	
}
