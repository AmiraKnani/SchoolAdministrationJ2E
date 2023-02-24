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
	<meta charset="utf-8">
	<title>Form-v10 by Colorlib</title>
	<!-- Mobile Specific Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<!-- Font-->
	<link rel="stylesheet" type="text/css" href="css/editStudent-styles.css">
	<link rel="stylesheet" type="text/css" href="css/designEditStudent-style.css">
	<!-- Main Style Css -->
    <link rel="stylesheet" href="css/editStudent-styles.css"/>
</head>
<body class="form-v10" >
<input type="hidden" id="status" value="<%= request.getAttribute("status")%>">
<!-- Navigation-->
	<div id="page-top">
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
					
					
				</ul>
			</div>
		</div>
	</nav>
	<!-- Content --><br/><br/><br/><br/>

		<div class="page-content">
		<div class="form-v10-content">
			<form class="form-detail" action="editStudent" method="post" id="myform">
				<div class="form-left">
					<h2>General Infomation</h2>
					<div class="form-row">
						<select name="title">
						    <option class="option" value="Mr">Mr</option>
						    <option class="option" value="Mrs">Mrs</option>
						</select>
						<span class="select-btn">
						  	<i class="zmdi zmdi-chevron-down"></i>
						</span>
					</div>
					<div class="form-group">
						<div class="form-row form-row-1">
							<input type="text" name="first_name" id="first_name" class="input-text" placeholder="First Name" >
						</div>
						<div class="form-row form-row-2">
							<input type="text" name="last_name" id="last_name" class="input-text" placeholder="Last Name" >
						</div>
					</div>
					<div class="form-row">
						<select name="position">
							<option value="field">Select field</option>
						    <option value="Bachelor's degree">Bachelor's degree</option>
						    <option value="Master's degree">Master's degree</option>
						    <option value="Engineer's degree">Engineer's degree</option>
						</select>
						<span class="select-btn">
						  	<i class="zmdi zmdi-chevron-down"></i>
						</span>
					</div>
					<div class="form-row">
						<input type="text" name="group" class="company" id="company" placeholder="Group" >
					</div>
					<div class="form-group">
						<div class="form-row form-row-3">
							<input type="date" id="birthday" name="birthday" >
						</div>
						<div class="form-row">
						<input type="number" name="id" class="id" id="id" placeholder="ID" required>
					</div>
					</div>
					<figure>
							<img src="https://www.pngitem.com/pimgs/m/394-3949380_transparent-social-studies-clipart-benefit-of-knowing-more.png" alt="editStudent image"  width="400" style = "position:relative; left:70px;top:30px;" 
     height="200">
						</figure>
				</div>
				<div class="form-right">
					<h2>Contact Details</h2>
					<div class="form-row">
						<input type="text" name="street" class="street" id="street" placeholder="Street + Nr" >
					</div>
					<div class="form-row">
						<input type="text" name="additional" class="additional" id="additional" placeholder="Additional Information" >
					</div>
					<div class="form-group">
						<div class="form-row form-row-1">
							<input type="number" name="zip" class="zip" id="zip" placeholder="Zip Code" >
						</div>
						<div class="form-row form-row-2">
							<select name="place">
							    <option value="place">Place</option>
							    <option value="Street">Street</option>
							    <option value="District">District</option>
							    <option value="City">City</option>
							</select>
							<span class="select-btn">
							  	<i class="zmdi zmdi-chevron-down"></i>
							</span>
						</div>
					</div>
					<div class="form-row">
						<select name="country">
						 	<option value="Country">Select country</option>
						    <option value="Tunisia">Tunisia</option>
						    <option value="EU">EU</option>
						    <option value="USA">USA</option>
						</select>
						<span class="select-btn">
						  	<i class="zmdi zmdi-chevron-down"></i>
						</span>
					</div>
					<div class="form-group">
						<div class="form-row form-row-1">
							<input type="number" name="code" class="code" id="code" placeholder="Code +" >
						</div>
						<div class="form-row form-row-2">
							<input type="number" name="phone" class="phone" id="phone" placeholder="Phone Number" >
						</div>
					</div>
					<div class="form-row">
						<input type="text" name="your_email" id="your_email" class="input-text"  pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}" placeholder="Email">
					</div>
					<div class="form-checkbox">
						<label class="container"><p>I do confirm the validity of the data inserted.</p>
						  	<input type="checkbox" name="checkbox" required>
						  	<span class="checkmark"></span>
						</label>
					</div>
					
					<div class="form-row-last">
						<input type="submit" name="test" class="register" value="ADD">
						<input type="submit" name="test" class="register" value="UPDATE">
						<input type="submit" name="test" class="register" value="DELETE">
					</div>
					
				</div>
			</form>
		</div>
	</div>
	</div>
	 <!-- Copyright Section-->
	 			<a href="Student" class="btn btn-outline-secondary  btn-lg active" role="button" aria-pressed="true" ><div class="fas fa-angle-double-left"></div></a> 
				<a href="editStudent" class="btn btn-outline-secondary  btn-lg active" role="button" aria-pressed="true" ><div class="fas fa-redo-alt"></div></a>
    
        <div class="copyright py-4 text-center text-white">
            <div class="container"><small>Copyright &copy; Polytech INTL 2022</small></div>
        </div>
        	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">

<script type="text/javascript">

	var status = document.getElementById("status").value;
	if(status == "success")
		{
		swal("Congrats","Operation done!","success")
		}

</script>
</body>
</html>