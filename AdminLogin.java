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
@WebServlet("/adminLo")
public class AdminLogin  extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","Krishna76@");
			PreparedStatement ps=cn.prepareStatement("select * from admin where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				PrintWriter pd=res.getWriter();
				pd.print("<h1>Admin Login SuccessFull!</h1>"
						+ "<h2>Admin Id: "+rs.getString(1)+"</h2>"
						+ "<h2>Admin Name: "+rs.getString(2)+"</h2>");	
				RequestDispatcher rd=req.getRequestDispatcher("BAdminProc.html");
				rd.include(req, res);
				
			}
			else {
				PrintWriter pd=res.getWriter();
				pd.print("<h1>InValid Credentials! Try Again....</h1>");
				RequestDispatcher rd=req.getRequestDispatcher("BAdminLogin.html");
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
