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


@WebServlet("/editStudent")
public class editStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("editStudent.jsp");
		
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id"); 
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String gender = request.getParameter("title");
		String cycle = request.getParameter("position");
		String groupe = request.getParameter("group");
		String birthday = request.getParameter("birthday");
		String street  = request.getParameter("street");
		String addit = request.getParameter("additional");
		String zip = request.getParameter("zip");
		String place = request.getParameter("place");
		String country = request.getParameter("country");
		String cod = request.getParameter("code");
		String phone = request.getParameter("phone");
		String email = request.getParameter("your_email");
		RequestDispatcher dispatcher = null; 
		Connection con=null;
		String op= request.getParameter("test");
		//ADD BUTTON
		if("ADD".equalsIgnoreCase(op))
		{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","1234");
			PreparedStatement pst = con.prepareStatement("insert into student(id, firstName, lastName, gender, cycle, groupe, birthday, street, addit, zip, place, country, cod, phone, email) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, id);
			pst.setString(2, firstName);
			pst.setString(3, lastName);
			pst.setString(4, gender);
			pst.setString(5, cycle);
			pst.setString(6, groupe);
			pst.setString(7, birthday);
			pst.setString(8, street);
			pst.setString(9, addit);
			pst.setString(10, zip);
			pst.setString(11, place);
			pst.setString(12, country);
			pst.setString(13, cod);
			pst.setString(14, phone);
			pst.setString(15, email);
			
			
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("editStudent.jsp");
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
			PreparedStatement pst = con.prepareStatement("delete from student where id=?");
			pst.setString(1, id);	
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("editStudent.jsp");
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
					PreparedStatement pst = con.prepareStatement("update student set firstName=? , lastName=?, gender=?, cycle=?, groupe=?, birthday=?, street=?, addit=?, zip=?, place=?, country=?, cod=?, phone=?, email=? where id=?");
					pst.setString(15, id);
					pst.setString(1, firstName);
					pst.setString(2, lastName);
					pst.setString(3, gender);
					pst.setString(4, cycle);
					pst.setString(5, groupe);
					pst.setString(6, birthday);
					pst.setString(7, street);
					pst.setString(8, addit);
					pst.setString(9, zip);
					pst.setString(10, place);
					pst.setString(11, country);
					pst.setString(12, cod);
					pst.setString(13, phone);
					pst.setString(14, email);
					
					
					int rowCount = pst.executeUpdate();
					dispatcher = request.getRequestDispatcher("editStudent.jsp");
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