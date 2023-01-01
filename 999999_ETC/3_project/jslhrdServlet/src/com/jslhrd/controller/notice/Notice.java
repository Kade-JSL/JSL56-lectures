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
}
