<%@page import="com.nagarro.util.ConsumeApiUtil"%>
<%@page import="com.nagarro.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Form</title>
<style type="text/css">
	<%@include file="Bootstrap/css/bootstrap.min.css"%>
	<%@include file="Bootstrap/css/custom.css"%>
</style>
<!-- Font Awesome CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<%
	request.getSession();
	String userName = (String) session.getAttribute("userName");
	if (userName != null) {
%>

<body>
	<!-- Header -->
	<div class="container-fliud">
		<div class="row">
			<div class="col-lg-12 mb-2"
				style="background-image: linear-gradient(#AFAEFD, #efe8de);">
				<div class="col-lg-12">
					<h1>
						<a class="navbar-brand" style="color: darkblue; font-size: 30px;"
							href="#">EMS</a>
					</h1>
				</div>
				<div class="col-lg-12 d-flex justify-content-end">
					<h3>
						Welcome user ! <a href="logout"><i
							style="color: red; font-size: 30px;" class="fa fa-times-circle"></i></a>
					</h3>
				</div>
			</div>
		</div>
	</div>
	<!-- Header -->
	<%! int employeeCode; Employee employee=null;%>
	<%
               employeeCode = Integer.parseInt(request.getParameter("employeeCode"));               
                employee = ConsumeApiUtil.getEmployeeById(employeeCode);
        
	%>
	<div class="container">
		<div class="row d-flex justify-content-center">
			<div class="col-lg-12">
				<div class="col-sm-12 col-lg-12 col-md-12 mt-3"
					style="border: 2px solid lightgray; border-radius: 5px;">
					<h5>
						<span class="pr-2 pl-2">Employee Listings</span>
					</h5>
					<form action="updateEmployee" method="post" class="col-lg-8 mx-auto">
						<div class="form-group row mt-4 d-flex justify-content-center">
							<label for="Name" class="col-sm-3 col-lg-3 col-form-label">Employee Code:</label>
							<div class="col-sm-6 col-md-8 col-lg-7">
								<input type="text" readonly class="form-control" name="employeeCode" value="<%=employee.getEmployeeCode()%>">
							</div>
						</div>
						<div class="form-group row d-flex justify-content-center">
							<label for="Email" class="col-sm-3 col-lg-3 col-form-label">Employee Name:</label>
							<div class="col-sm-6 col-md-8 col-lg-7">
								<input type="text" required class="form-control" name="employeeName" id="employeeName" value="<%=employee.getEmployeeName()%>" onblur="checkName()">
							</div>
						</div>
						
						<div class="form-group row mt-4 d-flex justify-content-center">
							<label for="Name" class="col-sm-3 col-lg-3 col-form-label">Location:</label>
							<div class="col-sm-6 col-md-8 col-lg-7">
								<textarea required class="form-control" name="location" id="location" onblur="checkLocation()"><%=employee.getLocation()%></textarea>
							</div>
						</div>
						<div class="form-group row d-flex justify-content-center">
							<label for="Email" class="col-sm-3 col-lg-3 col-form-label">Email:</label>
							<div class="col-sm-6 col-md-8 col-lg-7">
								<input type="email" required class="form-control" name="email" value="<%=employee.getEmail()%>" id="email" onblur="checkEmail()">
							</div>
						</div>
						
						<div class="form-group row d-flex justify-content-center">
						  <label for="example-date-input" class="col-sm-3 col-lg-3 col-form-label">Date Of Birth:</label>
						  <div class="col-sm-6 col-md-8 col-lg-7">
						    <input class="form-control" type="text" name="date" value="<%=ConsumeApiUtil.changeDate(employee.getDateOfBirth())%>" id="date" onblur="checkDate()" required>
						  </div>
						</div>
						
						<div class="form-group row d-flex justify-content-center">
						<label id="button" for="Email" class="col-sm-3 col-lg-3 col-form-label">
							<input type="submit" id="btn" name="submit" value="Submit">
						</label>							
							<div class="col-sm-6 col-md-8 col-lg-7 pl-0">
								<label for="Email" class="col-sm-3 col-lg-3 col-form-label">
							<input type="button" onclick="document.location.href='home'" name="cancel" value="Cancel">
						</label>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="row d-flex justify-content-center fixed-top">
		<div class="col-lg-6 ">
			<div id="alert">				
			</div>
		</div>
	</div>
		
	<!-- Footer -->
	<div style="background-image: linear-gradient(#efe8de, #AFAEFD);"
		class="page-footer font-small blue mt-3">
		<div class="footer-copyright text-center py-3">
			<h6 style="color: darkblue;">Copyright 2020-2021 by Fresher
				Training</h6>
		</div>
	</div>
	<!-- Footer -->

<%
	} else {
%>
	<div class="row d-flex justify-content-center fixed-top">
		<div class="col-lg-6 ">
			<div
				class="alert alert-primary alert-dismissible fade show d-flex justify-content-center">
				<button type="button" class="close" onclick="document.location.href='authUser'" data-dismiss="alert">&times;</button>
				<strong>Logged Out :( </strong>&nbsp; Please Login
			</div>
		</div>
	</div>

	<%
		}
	%>


	<script>
		<%@include file="Bootstrap/javascript/jquery.min.js"%>
		<%@include file="Bootstrap/javascript/popper.min.js"%>
		<%@include file="Bootstrap/javascript/bootstrap.min.js"%>		
		<%@include file="Bootstrap/javascript/validation.js"%>
	</script>
	
</body>
</html>