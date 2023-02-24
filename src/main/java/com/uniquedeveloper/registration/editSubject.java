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


@WebServlet("/editSubject")
public class editSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("editSubject.jsp");
		
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Mid = request.getParameter("idS"); 
		String matiere = request.getParameter("title");
		String coef = request.getParameter("coefficient");
		String typeM = request.getParameter("position");
		String Pid = request.getParameter("idP");
		
		RequestDispatcher dispatcher = null; 
		Connection con=null;
		String op= request.getParameter("test");
		//ADD BUTTON
		if("ADD".equalsIgnoreCase(op))
		{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","1234");
			PreparedStatement pst = con.prepareStatement("insert into matiere(Mid , matiere , coef , typeM, Pid) values(?,?,?,?,?)");
			pst.setString(1, Mid);
			pst.setString(2, matiere);
			pst.setString(3, coef);
			pst.setString(4, typeM);
			pst.setString(5, Pid);
			
			
			
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("editSubject.jsp");
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
			PreparedStatement pst = con.prepareStatement("delete from matiere where Mid=?");
			pst.setString(1, Mid);	
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("editSubject.jsp");
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
					PreparedStatement pst = con.prepareStatement("update matiere set matiere=? , coef=?, typeM=?, Pid=? where Mid=?");
					pst.setString(5, Mid);
					pst.setString(1, matiere);
					pst.setString(2, coef);
					pst.setString(3, typeM);
					pst.setString(4, Pid);
					
					
					int rowCount = pst.executeUpdate();
					dispatcher = request.getRequestDispatcher("editSubject.jsp");
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