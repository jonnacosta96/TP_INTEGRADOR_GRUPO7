<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/x-icon" href="favicon.ico">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/glyphicon.css" type="text/css"/>
	<link rel="stylesheet" href="./css/table.css" type="text/css"/>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="headerCliente.jsp"></jsp:include>
	<div style="background-color: #e9ecef; min-height:94vh!important" class="container-fluid py-3" >
	    <div class="container">
	        <h2>Transferir</h2>
	        <br>
	        <form>
	          <div class="border border-dark mb-4 px-5 py-3 pb-5 rounded">
	            <div class="row">
	              <div class="col">
	                <h5><label for="exampleInputEmail1">CBU destino</label></h5>
	                <input type="text" class="form-control" placeholder="Nombre" >
	              </div>
	              <div class="col">
	                <h5><label for="exampleInputEmail1">Transferir desde</label></h5>
	                <select class="form-select form-control" aria-label="Default select example">
	                  <option selected>Caja de ahorro ARS</option>
	                  <option value="1">Caja de ahorro USD</option>
	                </select>
	              </div>
	            </div>
	            <br>
	            <div class="row">
	              <div class="col">
	                <h5><label for="exampleInputEmail1">Monto</label></h5>
	                <input type="text" class="form-control" placeholder="Monto" >
	              </div>
	              <div class="col"></div>
	            </div>
	          </div>
	          <button type="submit" class="btn btn-primary d-inline">Transferir</button>
	          <button type="submit" class="btn btn-dark d-inline">Volver al inicio</button>
	        </form>
	    </div>
	</div>
</body>
</html>