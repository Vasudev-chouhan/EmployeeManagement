<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<style type="text/css">
	<%@include file="Bootstrap/css/bootstrap.min.css"%>
	<%@include file="Bootstrap/css/custom.css"%>
</style>
</head>

<body>
	<!-- Header -->
	<div class="mb-5 navbar navbar-expand-lg navbar-light bg-secondary" style="background-image: linear-gradient(#AFAEFD, #efe8de);">
		<h1><a class="navbar-brand" style="color: darkblue; font-size: 30px;" href="#">Welcome To EMS</a></h1>
	</div>
	<!-- Header -->
	
	<div class="container">
		<div class="row d-flex justify-content-center">
			<div class="col-lg-6">
				<form action="authUser" method="post"
				class="col-sm-12 col-lg-12 col-md-12 mt-3"	
				style="border: 2px solid lightgray; border-radius: 5px;">		
				<h5>
				<span class="pr-2 pl-2">Login</span>
				</h5>
				<div class="form-group row mt-4 d-flex justify-content-center">
				   	<label for="Name" class="col-sm-2 col-lg-2 col-form-label">User Id</label>				   	
				   	<div class="col-sm-6 col-md-8 col-lg-7">				   		
				   			<input type="text" required class="form-control" style="height: 30px;" name="userName" id="userName" onblur="checkUserName()">   		
				   	</div>
				</div>
				<div class="form-group row d-flex justify-content-center">
				   	<label for="Email" class="col-sm-2 col-lg-2 col-form-label">Password:</label>				   	
				   	<div class="col-sm-6 col-md-8 col-lg-7">
				   		<input type="password" required class="form-control" style="height: 30px;" name="password" id="password" onblur="checkPassword()">
				   		<input class="pt-0 pr-3 pl-3 mt-3" type="submit" id="btn" name="login" value="Login">				   		
				   	</div>
				</div>																																
  			</form>
			</div>
		</div>
	</div>
	
	<div class="row d-flex justify-content-end fixed-top">
		<div class="col-lg-6 ">
			<div id="alert">				
			</div>
		</div>
	</div>

	<% 
		if (request.getParameter("login") != null) {
	%>
		<div class="row d-flex justify-content-center fixed-top">
		<div class="col-lg-6 ">
			<div
				class="alert alert-danger alert-dismissible fade show d-flex justify-content-center">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>Invalid :( </strong>&nbsp; Username OR Password
			</div>
		</div>
	</div>
	<%
		}
	%>

	<!-- Footer -->
	<div style="background-image: linear-gradient(#efe8de, #AFAEFD);" class="page-footer font-small blue mt-5">		
		<div class="footer-copyright text-center py-3" >
			<h6 style="color: darkblue;">Copyright 2020-2021 by Fresher Training</h6>			
		</div>
	</div>
	<!-- Footer -->
	
	<script>
		<%@include file="Bootstrap/javascript/jquery.min.js"%>
		<%@include file="Bootstrap/javascript/popper.min.js"%>
		<%@include file="Bootstrap/javascript/bootstrap.min.js"%>		
		<%@include file="Bootstrap/javascript/validation.js"%>
	</script>	
</body>
</html>