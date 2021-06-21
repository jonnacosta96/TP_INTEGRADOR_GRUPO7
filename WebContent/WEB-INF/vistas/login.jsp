<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="./css/style2.css" type="text/css"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<title>Login</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a><img src="assets/img/logo.png" height="30px" alt="" style="margin-right: 10px;"></a>
        <container>
          <a class="navbar-brand mr-5 text-light">UTN Banking</a>
        <container>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
        </div>
        <div class="d-flex align-items-center">
          <container>
            <div class="dropdown ml-3 mr-5" dropdown>
            </div>
          </container>
        </div>
    </nav>
    <div class="container well" id="containerLogin">
		<center>
		<img src="./img/imagenLogin.jpg"  class="img-circle" />
		</center>
		<form:form id="loginForm" modelAttribute="login" action="loginProcess.html" method="post">
	         <div class="form-group">
                <form:input path="username" name="username" id="username" class="form-control"
			    	placeholder="Ingrese usuario"/>
             </div>
             <div class="form-group">	
           		<form:password path="password" name="password" id="password" class="form-control"
			    	placeholder="Ingrese contraseña"/>
	          </div>
	          <center>
                    <form:button id="login" name="login" class="btn btn-dark" value="Ingresar">Login</form:button>
                </center>
	     </form:form>
	     <center></center><p class="text-danger">${message}</td></center>
     </div>
</body>
</html>