package com.jslhrd.controller.faq;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.controller.JSLServletController;
import com.jslhrd.dao.FaqDao;
import com.jslhrd.dto.FaqDto;
import com.jslhrd.utility.Criteria;
import com.jslhrd.utility.PageDto;

public class Faq extends JSLServletController {

	public Faq(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}

	public void doGetList() throws IOException {
		FaqDao faqDao = FaqDao.getInstance();
		
		int pageNum = 1;
		if (request.getParameter("p") != null) {
			pageNum = Integer.parseInt(request.getParameter("p"));
		}
		int amount = 10;
		if (request.getParameter("a") != null) {
			amount = Integer.parseInt(request.getParameter("a"));
		}
		
		PageDto pageDto = new PageDto(new Criteria(pageNum, amount), faqDao.countFaq());
		List<FaqDto> dtoList = faqDao.selectFaqByNumber(pageNum * amount);
		
		request.setAttribute("pagemaker", pageDto);
		request.setAttribute("faqlist", dtoList);
	}
}
