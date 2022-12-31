package com.jslhrd.controller.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/summernote.do")
public class SummerNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SummerNoteServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String realPath = getServletContext().getRealPath("/upload");
		int maxImgSize = 1024 * 1024 * 2;
		String encType = "UTF-8";
		
		MultipartRequest mr = new MultipartRequest(
				request,
				realPath,
				maxImgSize,
				encType,
				new DefaultFileRenamePolicy()
				);
		
		response.setContentType("text/html, charset=UTF-8");
		PrintWriter out = response.getWriter();
		String file = mr.getFilesystemName("file");
		out.print("upload" + "/" + file);
		out.close();
	}

}
