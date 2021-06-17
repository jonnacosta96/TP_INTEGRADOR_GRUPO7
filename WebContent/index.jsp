<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="icon" type="image/x-icon" href="favicon.ico">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
<title>UTN Banking 2021</title>
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
    <div style="background-color: #e9ecef; min-height:94vh!important" class="container-fluid py-3" >
        <div class="d-flex justify-content-center mt5">
            <div class="col-3">
                <form>
                    <div class="text-center mb-4">
                    <h1 class="h3 mb-3 font-weight-normal">Login Prueba</h1>
                    </div>
                    <div class="form-label-group mb-2">
                    <label>Usuario</label>
                    <input type="text" class="form-control">
                    </div>
                    <div class="form-label-group mb-2">
                    <label>Password</label>
                    <input type="text" class="form-control">
                    </div>
                    <button class="btn btn-lg btn-primary btn-block mt-3" type="submit">Sign in</button>
                </form>
            </div>
        </div>
    </div>
<form action="RedirigirPagina1.html" method="get">
	<input type="submit" value="Redireccion a pagina prueba" name="btnRedirigir">
</form>
</body>
</html>