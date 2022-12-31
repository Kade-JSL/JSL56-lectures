<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSP의 HTML 부분은 필요가 없으면 지우면 된다 -->
<%@ page import="model.*" %>

<%
	request.setCharacterEncoding("utf-8");

	Vo vo = new Vo();

	vo.setSyear(request.getParameter("syear"));
	vo.setSclass(request.getParameter("sclass"));
	vo.setSno(request.getParameter("sno"));
	vo.setSname(request.getParameter("sname"));
	vo.setBirth(request.getParameter("birth"));
	vo.setGender(request.getParameter("gender"));
	vo.setTel1(request.getParameter("tel1"));
	vo.setTel2(request.getParameter("tel2"));
	vo.setTel3(request.getParameter("tel3"));
	
	Dao.getInstance().insertStudent(vo);
	
	response.sendRedirect("sub1.jsp");
%>