<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 1em;
        }

        nav {
            text-align: center;
            margin-top: 20px;
        }

        nav a {
            margin: 0 10px;
            text-decoration: none;
            color: #333;
            font-weight: bold;
        }

        nav a:hover {
            color: #555;
        }

        section {
            padding: 20px;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #333;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
<header>
        <h1>Customer's Data</h1>
    </header>
<%

Class.forName("com.mysql.cj.jdbc.Driver");
Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","Krishna76@");
PreparedStatement ps=cn.prepareStatement("select * from customer");
ResultSet rs=ps.executeQuery();
%>

<table cellPadding="40px" border="1" align="center">
<th>ID</th>
<th>Name</th>
<th>Account No</th>
<th>Pincode</th>
<th>Balance</th>
<th>Status</th>
<th>Update Customer Balance</th>
<%while(rs.next()){ %>
<tr>
	<td><%=rs.getString(1)%></td>
	<td><%=rs.getString(2) %> </td>
	<td><%=rs.getString(3) %> </td>
	<td><%=rs.getString(4) %> </td>
	<td><%=rs.getInt(5) %></td>
	<td><%=rs.getBoolean(6) %></td>
	<td><a href="BUpdate2.jsp?id=<%=rs.getInt(1)%>">update</a></td>


</tr>

<%} %>
</table>
</body>
</html>