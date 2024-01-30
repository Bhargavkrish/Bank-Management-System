package com.jsp.BankC;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.util.*;



@WebServlet("/custmoerRegis")
public class CustomerRegs  extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		id, name, accountno, pincode, balance, status
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","Krishna76@");
			PreparedStatement ps =cn.prepareStatement("insert into customer (id, name, accountno, pincode, balance, status) values(?,?,?,?,?,?)");
			
			String s=CustomerRegs.RandID(3);
			try {
				
			ps.setString(1, s);}
			catch(Exception e) {
				int i=0;
				s+=i;
				ps.setString(1, s);
				i++;
				
			}
			ps.setString(2, name);
			String s1=CustomerRegs.RandID(12);
			try {
				
			ps.setString(3, s1);}
			catch(Exception e) {
				int i=0;
				s1+=i;
				ps.setString(3, s1);
				i++;
				
			}
			
			ps.setString(4, password);
			ps.setInt(5, 3000);
			ps.setBoolean(6, true);
			ps.execute();
			
			PrintWriter pd=res.getWriter();
			pd.print("<h1>Customer Registration Successfull!</h1><h2>Your New Customer ID is:"+s+"& \nCustomer BankAccount Number is: "+s1+"</h2>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String  RandID(int n) {
		Random r=new Random();
		String k="";
		for(int i=0;i<n;i++) {
			int l=r.nextInt(9);
			k+=l;
			
		
		}
		
		return k;
	}

}
