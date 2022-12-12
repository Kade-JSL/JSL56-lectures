package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ArtistDto;
import dao.ArtistDao;

@WebServlet("/sub1pro.do")
public class Sub1ProServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Sub1ProServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		ArtistDto dto = new ArtistDto();
		
		dto.setArtist_id(request.getParameter("artist_id"));
		dto.setArtist_name(request.getParameter("artist_name"));
		dto.setArtist_gender(request.getParameter("artist_gender"));
		dto.setArtist_birth(request.getParameter("artist_birth"));
		dto.setTalent(request.getParameter("talent"));
		dto.setAgency(request.getParameter("agency"));
		
		ArtistDao dao = ArtistDao.getInstance();
		dao.insertArtist(dto);
		
		response.sendRedirect("sub1.do");
	}

}
