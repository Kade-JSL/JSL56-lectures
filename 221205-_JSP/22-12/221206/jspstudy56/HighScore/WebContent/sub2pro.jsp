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
	vo.setKor(Integer.parseInt(request.getParameter("kor")));
	vo.setEng(Integer.parseInt(request.getParameter("eng")));
	vo.setMat(Integer.parseInt(request.getParameter("mat")));
	
	Dao.getInstance().insertScore(vo);
	
	response.sendRedirect("sub2.jsp");
%>