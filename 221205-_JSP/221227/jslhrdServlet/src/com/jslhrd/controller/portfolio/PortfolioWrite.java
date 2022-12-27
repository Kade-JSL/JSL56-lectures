package com.jslhrd.controller.portfolio;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.dao.PortfolioDao;
import com.jslhrd.dto.PortfolioDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/write.do")
public class PortfolioWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PortfolioWrite() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/portfolio/write.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		PortfolioDto dto = new PortfolioDto();
		
//		dto.setTitle(request.getParameter("title"));
//		dto.setContent(request.getParameter("content"));
				
		String realPath = getServletContext().getRealPath("/upload");
		System.out.println(realPath);
		int maxImgSize = 1024 * 1024 * 2;
		String encType = "UTF-8";
		
		MultipartRequest mr = new MultipartRequest(
				request,
				realPath,
				maxImgSize,
				encType,
				new DefaultFileRenamePolicy()
				);
		
		dto.setTitle(mr.getParameter("title"));
		dto.setContent(mr.getParameter("content"));
		dto.setImgurl(mr.getFilesystemName("imgurl"));
		
		PortfolioDao.getInstance().insertPort(dto);
		
		response.sendRedirect("portfolio.do");
	}

}
