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


@WebServlet("/Settings")
public class Settings extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("Settings.jsp");
		
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String umobile = request.getParameter("cno"); 
		String upwd = request.getParameter("new");
		RequestDispatcher dispatcher = null; 
		Connection con=null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","1234");
					PreparedStatement pst = con.prepareStatement("update users set upwd=? where uemail=?");
					pst.setString(1, upwd);
					pst.setString(2, umobile);

					
					
					int rowCount = pst.executeUpdate();
					dispatcher = request.getRequestDispatcher("Settings.jsp");
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
	
	



