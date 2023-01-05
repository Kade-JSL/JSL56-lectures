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

@WebServlet("/portwrite.do")
public class PortfolioWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PortfolioWrite() {
        super();
    }
    
    private static String imgurl = null;
    public static String getImgurl() { return imgurl; }
    public static void setImgurl(String url) { imgurl = url; }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/portfolio/write.jsp";
		if (request.getParameter("tbl") != null) {
			if (request.getParameter("tbl").equals("qa")) {
				url = "/qna/qawrite.jsp";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		PortfolioDto dto = new PortfolioDto();
		
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setImgurl(imgurl);
//				
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
		imgurl = null;
		
		response.sendRedirect("list.do?t=port");
	}

}
