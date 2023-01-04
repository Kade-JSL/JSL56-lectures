package com.jslhrd.controller.portfolio;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.controller.JSLServletController;
import com.jslhrd.controller.notice.SummerNoteServlet;
import com.jslhrd.dao.PortfolioDao;
import com.jslhrd.dto.PortfolioDto;
import com.jslhrd.utility.Criteria;
import com.jslhrd.utility.PageDto;

public class Portfolio extends JSLServletController {

	public Portfolio(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}
	
	Criteria cri;
	PageDto pagemaker;

	public void doGetList() throws IOException {
		PortfolioDao pageDao = PortfolioDao.getInstance();
		int pageNum = 1, amount = 5;
		if (request.getParameter("p") != null) {
			pageNum = Integer.parseInt(request.getParameter("p"));
		}
		if (request.getParameter("a") != null) {
			amount = Integer.parseInt(request.getParameter("a"));
		}

		cri = new Criteria(pageNum, amount);
		pagemaker = new PageDto(cri, pageDao.portCount());
		List<PortfolioDto> tblList = pageDao.readPortList(cri);
		for (PortfolioDto p : tblList) {
			p.setContent(p.getContent().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""));
		}
		
		request.setAttribute("pagemaker", pagemaker);
		request.setAttribute("list", tblList);
	}
	
	public void doGetView() throws IOException {
		PortfolioDao dao = PortfolioDao.getInstance();
		int bno = Integer.parseInt(request.getParameter("n"));
		int pageNum = 1, amount = 5;
		if (request.getParameter("p") != null) {
			pageNum = Integer.parseInt(request.getParameter("p"));
		}
		if (request.getParameter("a") != null) {
			amount = Integer.parseInt(request.getParameter("a"));
		}
		cri = new Criteria(pageNum, amount);
		pagemaker = new PageDto(cri, dao.portCount());
		Map<String, Object> view = dao.readPortContent(bno);
		
		request.setAttribute("pagemaker", pagemaker);
		request.setAttribute("view", view);
	}
	
	public void doGetWrite() throws IOException {
		
	}

	public void doPostWrite() throws IOException {
		PortfolioDto dto = new PortfolioDto();
		
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setImgurl(SummerNoteServlet.getImgurl());
		SummerNoteServlet.setImgurl(null);
		
//		String realPath = getServletContext().getRealPath("/upload");
//		System.out.println(realPath);
//		int maxImgSize = 1024 * 1024 * 2;
//		String encType = "UTF-8";
//		
//		MultipartRequest mr = new MultipartRequest(
//				request,
//				realPath,
//				maxImgSize,
//				encType,
//				new DefaultFileRenamePolicy()
//				);
//		
//		dto.setTitle(mr.getParameter("title"));
//		dto.setContent(mr.getParameter("content"));
//		dto.setImgurl(mr.getFilesystemName("imgurl"));
		
		PortfolioDao.getInstance().insertPort(dto);
	}
}
