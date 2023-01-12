package com.shim.controller.kade;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shim.dao.UsrDao;
import com.shim.utility.SHA256;

@WebServlet("/kade.do")
public class Kade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Kade() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/kade/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("kade-email");
		String pw = SHA256.encode(request.getParameter("kade-pw"));
		Map<String, Object> user = UsrDao.getInstance().login(id, pw);
		if (user != null) {
			if (user.get("uname") != null) {
				HttpSession session = request.getSession();
				user.put("uname", user.get("uname"));
				user.put("lastread", 0);
				user.put("outerpiece", "?usr=admin");
				session.setAttribute("user", user);
			}
		} else {
			request.setAttribute("msg", "貴方はご主人様ではありません。");
		}
		response.sendRedirect("main.do");
	}

}
