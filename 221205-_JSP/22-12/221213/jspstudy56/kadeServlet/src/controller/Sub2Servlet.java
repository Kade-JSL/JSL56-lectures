package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArtistDao;
import dto.ArtistDto;

@WebServlet("/sub2.do")
public class Sub2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Sub2Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ArtistDto> artistDtoList = ArtistDao.getInstance().selectArtist();
		request.setAttribute("dtoList", artistDtoList);
		
		RequestDispatcher rd = request.getRequestDispatcher("sub2.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
