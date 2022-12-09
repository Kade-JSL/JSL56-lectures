<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%
	request.setCharacterEncoding("UTF-8");

	Dto dto = new Dto();
	
	dto.setP_seno(Integer.parseInt(request.getParameter("p_seno")));
	dto.setP_no(request.getParameter("p_no"));
	dto.setI_code(request.getParameter("i_code"));
	dto.setP_date(request.getParameter("p_date"));
	
	Dao dao = Dao.getInstance();
	dao.insertOrder(dto);
	
	response.sendRedirect("sub2.jsp");
%>