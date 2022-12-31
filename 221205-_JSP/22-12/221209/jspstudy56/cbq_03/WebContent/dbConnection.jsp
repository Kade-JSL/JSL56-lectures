<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
try {
Class.forName("oracle.jdbc.OracleDriver");
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "kade01", "1234");
if (con != null) {
out.println("Database Connection : [ " + " <b>success</b> ]<br>");
} else {
out.println("Database Connection : [ " + " <b>fail</b> ]<br>");
}
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("select sysdate from dual");
while (rs.next()) {
out.println("Today date : " + rs.getString(1) + "<hr>");
}
stmt.close();
con.close();
} catch (Exception e) {
e.printStackTrace();
}
%>