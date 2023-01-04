package com.jslhrd.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.dao.MemberDao;
import com.jslhrd.utility.SHA256;

@WebServlet("/admin.do")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/adm/admin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String pw = SHA256.encode(request.getParameter("pw"));
		switch(MemberDao.getInstance().memberIdPwCheck("admin", pw)) {
			case 1:
				HttpSession session = request.getSession();
				session.setAttribute("id", "admin");
				request.getRequestDispatcher("/adm/adminmain.jsp").forward(request, response);
				break;
			case 0:	case -1:
				request.setAttribute("msg", "아이디 또는 비밀번호를 확인하세요.");
				request.getRequestDispatcher("/adm/admin.jsp").forward(request, response);
				break;
		}
	}

}
