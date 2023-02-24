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


@WebServlet("/editProfessor")
public class editProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("editProfessor.jsp");
		
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Pid = request.getParameter("id"); 
		String PfirstName = request.getParameter("first_name");
		String PlastName = request.getParameter("last_name");
		String Pgender = request.getParameter("title");
		String Pcycle = request.getParameter("position");
		String Psubject = request.getParameter("subject");
		String Pbirthday = request.getParameter("birthday");
		String Pstreet  = request.getParameter("street");
		String Paddit = request.getParameter("additional");
		String Pzip = request.getParameter("zip");
		String Pplace = request.getParameter("place");
		String Pcountry = request.getParameter("country");
		String Pcod = request.getParameter("code");
		String Pphone = request.getParameter("phone");
		String Pemail = request.getParameter("your_email");
		RequestDispatcher dispatcher = null; 
		Connection con=null;
		String op= request.getParameter("test");
		//ADD BUTTON
		if("ADD".equalsIgnoreCase(op))
		{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","1234");
			PreparedStatement pst = con.prepareStatement("insert into professor(Pid, PfirstName, PlastName, Pgender, Pcycle, Psubject, Pbirthday, Pstreet, Paddit, Pzip, Pplace, Pcountry, Pcod, Pphone, Pemail) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, Pid);
			pst.setString(2, PfirstName);
			pst.setString(3, PlastName);
			pst.setString(4, Pgender);
			pst.setString(5, Pcycle);
			pst.setString(6, Psubject);
			pst.setString(7, Pbirthday);
			pst.setString(8, Pstreet);
			pst.setString(9, Paddit);
			pst.setString(10, Pzip);
			pst.setString(11, Pplace);
			pst.setString(12, Pcountry);
			pst.setString(13, Pcod);
			pst.setString(14, Pphone);
			pst.setString(15, Pemail);
			
			
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("editProfessor.jsp");
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
			PreparedStatement pst = con.prepareStatement("delete from professor where Pid=?");
			pst.setString(1, Pid);	
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("editProfessor.jsp");
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
					PreparedStatement pst = con.prepareStatement("update professor set PfirstName=? , PlastName=?, Pgender=?, Pcycle=?, Psubject=?, Pbirthday=?, Pstreet=?, Paddit=?, Pzip=?, Pplace=?, Pcountry=?, Pcod=?, Pphone=?, Pemail=? where Pid=?");
					pst.setString(15, Pid);
					pst.setString(1, PfirstName);
					pst.setString(2, PlastName);
					pst.setString(3, Pgender);
					pst.setString(4, Pcycle);
					pst.setString(5, Psubject);
					pst.setString(6, Pbirthday);
					pst.setString(7, Pstreet);
					pst.setString(8, Paddit);
					pst.setString(9, Pzip);
					pst.setString(10, Pplace);
					pst.setString(11, Pcountry);
					pst.setString(12, Pcod);
					pst.setString(13, Pphone);
					pst.setString(14, Pemail);
					
					
					int rowCount = pst.executeUpdate();
					dispatcher = request.getRequestDispatcher("editProfessor.jsp");
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