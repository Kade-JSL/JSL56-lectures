package com.shim.controller.usr;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.shim.dao.UsrDao;
import com.shim.utility.SHA256;


@WebServlet("/signup.do")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignUp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/usr/signup.jsp").forward(request, response);
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
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", mr.getParameter("email"));
		map.put("uname", mr.getParameter("uname"));
		map.put("pw", SHA256.encode(mr.getParameter("pw")));
		String profileimg = mr.getFilesystemName("profileimg");
		if (profileimg == null) { profileimg = "upload/basicpic.jpg"; }
		map.put("profileimg", profileimg);
		
		UsrDao.getInstance().createUser(map);
		
		response.sendRedirect("main.do");
	}

}
