package controller;

import DBManager.DBManager;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/dbconnection.do")
public class DbTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DbTestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		DBManager dbm = DBManager.getInstance();
		conn = dbm.getConnection();
		if (conn != null) {
			request.setAttribute("result", "접속 완료!");
		} else {
			request.setAttribute("result", "접속 에러...");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("dbtest.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
