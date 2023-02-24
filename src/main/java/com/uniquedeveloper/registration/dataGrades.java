package com.uniquedeveloper.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class dataStudent
 */
@WebServlet("/dataGrades")
public class dataGrades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null; 
		Connection con=null;
		try {
			response.setContentType("text/html");
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","1234");
			PreparedStatement pst = con.prepareStatement("select subjectG, typeG, grade, idS from grades");	
			ResultSet rs = pst.executeQuery();
			
			PrintWriter out = response.getWriter();
			
			out.println("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"utf-8\" />\r\n"
					+ "<meta name=\"viewport\"\r\n"
					+ "	content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\r\n"
					+ "<meta name=\"description\" content=\"\" />\r\n"
					+ "<meta name=\"author\" content=\"\" />\r\n"
					+ "<title>Polytech INTL</title>\r\n"
					+ "<!-- Favicon-->\r\n"
					+ "<link rel=\"icon\" type=\"image/x-icon\" href=\"assets/favicon.ico\" />\r\n"
					+ "<!-- Font Awesome icons (free version)-->\r\n"
					+ "<script src=\"https://use.fontawesome.com/releases/v5.15.4/js/all.js\"\r\n"
					+ "	crossorigin=\"anonymous\"></script>\r\n"
					+ "<!-- Google fonts-->\r\n"
					+ "<link href=\"https://fonts.googleapis.com/css?family=Montserrat:400,700\"\r\n"
					+ "	rel=\"stylesheet\" type=\"text/css\" />\r\n"
					+ "<link\r\n"
					+ "	href=\"https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic\"\r\n"
					+ "	rel=\"stylesheet\" type=\"text/css\" />\r\n"
					+ "<!-- Core theme CSS (includes Bootstrap)-->\r\n"
					+ "<link href=\"css/index-styles.css\" rel=\"stylesheet\" />\r\n"
					+ "	<meta charset=\"utf-8\">\r\n"
					+ "	<title>Form-v10 by Colorlib</title>\r\n"
					+ "	<!-- Mobile Specific Metas -->\r\n"
					+ "	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n"
					+ "	<!-- Font-->\r\n"
					+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"css/editStudent-styles.css\">\r\n"
					+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"css/designEditStudent-style.css\">\r\n"
					+ "	<!-- Main Style Css -->\r\n"
					+ "    <link rel=\"stylesheet\" href=\"css/editStudent-styles.css\"/>\r\n"
					+ "</head>\r\n"
					+ "<body class=\"form-v10\" >\r\n"
					+ "<input type=\"hidden\" id=\"status\" value=\"<%= request.getAttribute(\"status\")%>\">\r\n"
					+ "<!-- Navigation-->\r\n"
					+ "	<div id=\"page-top\">\r\n"
					+ "	<nav \r\n"
					+ "		class=\"navbar navbar-expand-lg bg-secondary text-uppercase fixed-top\"\r\n"
					+ "		id=\"mainNav\">\r\n"
					+ "		<div class=\"container\">\r\n"
					+ "			<a class=\"navbar-brand\" href=\"home\">POLYTECH INTL</a>\r\n"
					+ "			<button\r\n"
					+ "				class=\"navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded\"\r\n"
					+ "				type=\"button\" data-bs-toggle=\"collapse\"\r\n"
					+ "				data-bs-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\"\r\n"
					+ "				aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n"
					+ "				Menu <i class=\"fas fa-bars\"></i>\r\n"
					+ "			</button>\r\n"
					+ "			<div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\r\n"
					+ "				<ul class=\"navbar-nav ms-auto\">\r\n"
					+ "					<li class=\"nav-item mx-0 mx-lg-1\"><a\r\n"
					+ "						class=\"nav-link py-3 px-0 px-lg-3 rounded\" href=\"home\">Menu</a></li>\r\n"
					+ "					<li class=\"nav-item mx-0 mx-lg-1\"><a\r\n"
					+ "						class=\"nav-link py-3 px-0 px-lg-3 rounded\" href=\"Settings\">Settings</a></li>\r\n"
					+ "					<li class=\"nav-item mx-0 mx-lg-1\"><a\r\n"
					+ "						class=\"nav-link py-3 px-0 px-lg-3 rounded\" href=\"#contact\">About</a></li>\r\n"
					+ "					<li class=\"nav-item mx-0 mx-lg-1\"><a\r\n"
					+ "						class=\"nav-link py-3 px-0 px-lg-3 rounded\" href=\"Logout\">Logout</a></li>\r\n"
					+ "					\r\n"
					+ "					\r\n"
					+ "				</ul>\r\n"
					+ "			</div>\r\n"
					+ "		</div>\r\n"
					+ "	</nav>\r\n"
					+ "	\r\n"
					+ "	<br/><br/><br/><br/>\r\n"
					+ "	<!-- Content -->\r\n"
					+ "	<div class=\"table-responsive\">\r\n"
					+ "  <!--Table-->\r\n"
					+ "<p> &nbsp <a class=\"navbar-toggler text-uppercase font-weight-bold bg-danger text-white rounded\">Grades Data</a> &nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  "
					+ "<input type=\"text\" id=\"myInput\" onkeyup=\"myFunction()\" placeholder=\"Search for ID..\" title=\"Type in a name\"></p><hr/>"
					+ "  <table id=\"myTable\" class=\"table table-striped\">\r\n"
					+ "\r\n"
					+ "    <!--Table head-->\r\n"
					+ "    <thead>\r\n"
					+ "      <tr>\r\n"
					+ "        <th>Student ID</th>\r\n"
					+ "        <th>Subject</th>\r\n"
					+ "        <th>Type</th>\r\n"
					+ "        <th>Grade</th>\r\n"
					+ "      </tr>\r\n"
					+ "    </thead>\r\n"
					+ "    <!--Table head-->\r\n"
					+ "\r\n"
					+ "    <!--Table body-->\r\n"
					+ "    <tbody>\r\n"
					+ "      ");
			
			while(rs.next()) {
				out.println("<tr><td>"+rs.getString(4)+"</td><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><tr>");
			}
			
			
			
			
			out.println("    </tr></tbody>\r\n"
					+ "    <!--Table body-->\r\n"
					+ "  </table>\r\n"
					+ "  <!--Table-->\r\n"
					+ "</div>\r\n"
					+ "	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>\r\n"
					+ "<script>\r\n"
					+ "function myFunction() {\r\n"
					+ "  var input, filter, table, tr, td, i, txtValue;\r\n"
					+ "  input = document.getElementById(\"myInput\");\r\n"
					+ "  filter = input.value.toUpperCase();\r\n"
					+ "  table = document.getElementById(\"myTable\");\r\n"
					+ "  tr = table.getElementsByTagName(\"tr\");\r\n"
					+ "  for (i = 0; i < tr.length; i++) {\r\n"
					+ "    td = tr[i].getElementsByTagName(\"td\")[0];\r\n"
					+ "    if (td) {\r\n"
					+ "      txtValue = td.textContent || td.innerText;\r\n"
					+ "      if (txtValue.toUpperCase().indexOf(filter) > -1) {\r\n"
					+ "        tr[i].style.display = \"\";\r\n"
					+ "      } else {\r\n"
					+ "        tr[i].style.display = \"none\";\r\n"
					+ "      }\r\n"
					+ "    }       \r\n"
					+ "  }\r\n"
					+ "}\r\n"
					+ "</script>"
					
					+ "	<!-- Copyright Section-->  \r\n"
					+ "<a href=\"Grades\" class=\"btn btn-outline-secondary  btn-lg active\" role=\"button\" aria-pressed=\"true\" ><div class=\"fas fa-angle-double-left\"></div></a> "
					+ "<a href=\"dataGrades\" class=\"btn btn-outline-secondary  btn-lg active\" role=\"button\" aria-pressed=\"true\" ><div class=\"fas fa-redo-alt\"></div></a>\r\n "				
					
					+ "        <div class=\"copyright py-4 text-center text-white\">\r\n"
					+ "            <div class=\"container\"><small>Copyright &copy; Polytech INTL 2022</small></div>\r\n"
					+ "        </div>\r\n "
					+ "</body>\r\n"
					+ "</html>");
			
			
		
				
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	

}
