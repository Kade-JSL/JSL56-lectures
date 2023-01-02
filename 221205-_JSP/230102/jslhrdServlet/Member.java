package com.jslhrd.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.dao.MemberDao;
import com.jslhrd.dto.MemberDto;
import com.jslhrd.utility.SHA256;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/member.do")
public class Member extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Member() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/member/member.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		MemberDto dto = new MemberDto();
		dto.setName(mr.getParameter("name"));
		dto.setNickname(mr.getParameter("nickname"));
		dto.setId(mr.getParameter("id"));
		dto.setPw(SHA256.encode(mr.getParameter("pw")));
		dto.setPhone(mr.getParameter("phone"));
		dto.setEmail(mr.getParameter("email"));
		dto.setProfileimg(mr.getFilesystemName("profileimg"));
		MemberDao.getInstance().insertMember(dto);
		
		response.sendRedirect("/main.do");
	}

}
