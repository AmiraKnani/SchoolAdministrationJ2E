<%
	if (session.getAttribute("name")==null){
		response.sendRedirect("login.jsp");
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Polytech INTL</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/index-styles.css" rel="stylesheet" />
</head>
<body id="page-top">
	<!-- Navigation-->
	<nav
		class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="home">POLYTECH INTL</a>
			<button
				class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded"
				type="button" data-bs-toggle="collapse"
				data-bs-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="home">Menu</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="Settings">Settings</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="#contact">About</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="Logout">Logout</a></li>
					<li class="nav-item mx-0 mx-lg-1 bg-danger"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="Logout"><%= session.getAttribute("name") %></a></li>
					
				</ul>
			</div>
		</div>
	</nav> 
	<!-- Choice-->   
	<br/>
	<div class="tab1cards">
  <div class="card" style="width:300px">
  <img class="card-img-top" src="https://media.istockphoto.com/vectors/student-avatar-flat-icon-flat-vector-illustration-symbol-design-vector-id1212812078?k=20&m=1212812078&s=170667a&w=0&h=Pl6TaYY87D2nWwRSWmdtJJ0DKeD5vPowomY9fyeqNOs=" alt="Card image">
  <div class="card-body">
    <h4 class="card-title">Student Management</h4>
    <br/>
    <a href="Student" class="btn btn-primary">Access Student</a>
  </div>
  </div>

  <div class="card" style="width:300px">
  <img class="card-img-top" src=https://img.freepik.com/vector-premium/retrato-personaje-cerveza-barbudo-ropa-formal-traje-corbata-catedratico-universitario-joven-profesor-o-estudiante-colegio-traje-adolescente-barba-vector-personaje-seguro-plano_87689-2394.jpg?w=360 alt="Card image">
  <div class="card-body">
    <h4 class="card-title">Professor Management</h4>
    <br/>
    <a href="Professor" class="btn btn-primary">Access Professor</a>
  </div>
  </div>
  <br/>
  <div class="card" style="width:300px">
  <img class="card-img-top" src=https://cdn.pixabay.com/photo/2016/09/16/09/20/books-1673578_960_720.png alt="Card image"  width="400">
  <div class="card-body">
    <h4 class="card-title">Subject Management</h4>
    <br/>
    <a href="Subject" class="btn btn-primary">Access Subject</a>
  </div>
  </div>
 <br/>
  <div class="card" style="width:300px">
  <img class="card-img-top" src=https://thumbs.dreamstime.com/b/exam-test-paper-answers-pencil-exam-test-paper-answers-pencil-assessment-knowledge-paper-pen-115068385.jpg alt="Card image" >
  <div class="card-body">
    <h4 class="card-title">Grades <br/> Management</h4>
    <br/>
    <a href="Grades" class="btn btn-primary">Access Grades</a>
  </div>
  </div>
  <br/>
  <div class="card" style="width:300px">
  <img class="card-img-top" src=https://cdn.icon-icons.com/icons2/1736/PNG/512/4043260-avatar-male-man-portrait_113269.png alt="Card image" >
  <div class="card-body">
    <h4 class="card-title">Administration <br/> Management</h4>
    <br/>
    <a href="Admin" class="btn btn-primary">Access Administration</a>
  </div>
  </div>
 
  </div>
    <!-- Copyright Section-->
    <br/><br/>
        <div class="copyright py-4 text-center text-white">
            <div class="container"><small>Copyright &copy; Polytech INTL 2022</small></div>
        </div>
  
</body>
</html>
