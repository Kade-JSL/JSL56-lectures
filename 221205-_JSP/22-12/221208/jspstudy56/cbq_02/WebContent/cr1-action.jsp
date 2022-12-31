<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.*" %>

<%
	request.setCharacterEncoding("UTF-8");

	Dto dto = new Dto();
	Dao dao = Dao.getDao();
	
	dto.setArtist_id(request.getParameter("artist_id"));
	dto.setArtist_name(request.getParameter("artist_name"));
	String birth =
			request.getParameter("artist_birth1") +
			request.getParameter("artist_birth2") +
			request.getParameter("artist_birth3");
	dto.setArtist_birth(birth);
	dto.setArtist_gender(request.getParameter("artist_gender"));
	dto.setTalent(request.getParameter("talent"));
	dto.setAgency(request.getParameter("agency"));
	
	dao.insertArtist(dto);
	
	response.sendRedirect("create-artist.jsp");
%>