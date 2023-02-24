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


@WebServlet("/editGrades")
public class editGrades extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("editGrades.jsp");
		
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idS = request.getParameter("idS"); 
		String matiereID = request.getParameter("idM"); 
		String subjectG = request.getParameter("title");
		String typeG = request.getParameter("position");
		String grade = request.getParameter("grade");
		
		RequestDispatcher dispatcher = null; 
		Connection con=null;
		String op= request.getParameter("test");
		//ADD BUTTON
		if("ADD".equalsIgnoreCase(op))
		{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","1234");
			PreparedStatement pst = con.prepareStatement("insert into grades(idS , matiereID , subjectG , typeG, grade) values(?,?,?,?,?)");
			pst.setString(1, idS);
			pst.setString(2, matiereID);
			pst.setString(3, subjectG);
			pst.setString(4, typeG);
			pst.setString(5, grade);
			
			
			
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("editGrades.jsp");
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
			PreparedStatement pst = con.prepareStatement("delete from grades where idS=? and matiereID=?");
			pst.setString(1, idS);	
			pst.setString(2, matiereID);
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("editGrades.jsp");
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
					PreparedStatement pst = con.prepareStatement("update grades set grade=? where idS=? and matiereID=?");
					pst.setString(1, grade);
					pst.setString(2, idS);
					pst.setString(3, matiereID);
					
					
					int rowCount = pst.executeUpdate();
					dispatcher = request.getRequestDispatcher("editGrades.jsp");
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