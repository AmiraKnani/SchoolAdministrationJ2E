package com.uniquedeveloper.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/editAdmin")
public class editAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("editAdmin.jsp");
		
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("name"); 
		String uemail = request.getParameter("email");
		String umobile = request.getParameter("mobile");
		String upwd = request.getParameter("pwd"); 
		
		RequestDispatcher dispatcher = null; 
		Connection con=null;
		String op= request.getParameter("test");
		//ADD BUTTON
		if("ADD".equalsIgnoreCase(op))
		{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","1234");
			PreparedStatement pst = con.prepareStatement("insert into users(uname , uemail , umobile , upwd) values(?,?,?,?)");
			pst.setString(1, uname);
			pst.setString(2, uemail);
			pst.setString(3, umobile);
			pst.setString(4, upwd); 
			
			
			
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("editAdmin.jsp");
			if (rowCount>0)
			{
				request.setAttribute("status", "success");
				
			}else {
				request.setAttribute("status", "failed");
			}
			dispatcher.forward(request,response);
				
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
		//DELETE BUTTON
		if("DELETE".equalsIgnoreCase(op))
		{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","1234");
			PreparedStatement pst = con.prepareStatement("delete from users where uemail=?");
			pst.setString(1, uemail);	
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("editAdmin.jsp");
			if (rowCount>0)
			{
				request.setAttribute("status", "success");
				
			}else {
				request.setAttribute("status", "failed");
			}
			dispatcher.forward(request,response);
				
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
		//UPDATE BUTTON
				if("UPDATE".equalsIgnoreCase(op))
				{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","1234");
					PreparedStatement pst = con.prepareStatement("update users set uname=? , upwd=?, umobile=? where uemail=?");
					pst.setString(1, uname);
					pst.setString(2, upwd);
					pst.setString(3, umobile);
					pst.setString(4, uemail);
					
					
					int rowCount = pst.executeUpdate();
					dispatcher = request.getRequestDispatcher("editAdmin.jsp");
					if (rowCount>0)
					{
						request.setAttribute("status", "success");
						
					}else {
						request.setAttribute("status", "failed");
					}
					dispatcher.forward(request,response);
						
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				
			}
		


}
	
	



}