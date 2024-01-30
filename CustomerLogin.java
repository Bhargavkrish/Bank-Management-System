package com.jsp.BankC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/customerlogin")
public class CustomerLogin  extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","Krishna76@");
			PreparedStatement ps=cn.prepareStatement("select * from customer where name=? and pincode=?");
			ps.setString(1, name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				PrintWriter pd=res.getWriter();
				pd.print("<h1>Login SuccessFull!</h1>");
				
			}
			else {
				PrintWriter pd=res.getWriter();
				pd.print("<h1>InValid Credentials! Try Again....</h1>");
				RequestDispatcher rd=req.getRequestDispatcher("BCustomerLogin.html");
				rd.include(req, res);
			}
			cn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
