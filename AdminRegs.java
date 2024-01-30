package com.jsp.BankC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/adminRe")
public class AdminRegs extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","Krishna76@");
			PreparedStatement ps=cn.prepareStatement("insert into Admin (id, name, email, password) values(?,?,?,?)");
			String s=AdminRegs.RandID();
			try {
				
			ps.setString(1, s);}
			catch(Exception e) {
				int i=0;
				s+=i;
				i++;
				
			}
		
			
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.execute();
			cn.close();
			RequestDispatcher rd=req.getRequestDispatcher("Bwelcome.html");
			rd.forward(req, res);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static String  RandID() {
		Random r=new Random();
		String k="";
		for(int i=0;i<3;i++) {
		 k+=r.nextInt(10);
		 
		
		}
		
		return k;
	}

}
