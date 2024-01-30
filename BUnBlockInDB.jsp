
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

String id=request.getParameter("id");
Class.forName("com.mysql.cj.jdbc.Driver");
Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","Krishna76@");
PreparedStatement pd=cn.prepareStatement("update customer  set status=? where id=?");
pd.setBoolean(1, true);
pd.setString(2,id);
pd.execute();

RequestDispatcher rd=request.getRequestDispatcher("BUnBlockCustomer.jsp");
rd.forward(request, response);


%>
</body>
</html>