<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/glyphicon.css" type="text/css"/>
	<link rel="stylesheet" href="./css/table.css" type="text/css"/>
	
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
    <title>Client</title>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>	
    
    <div style="background-color: #e9ecef; min-height:94vh!important" class="container-fluid py-3" >
        <div></div>
        <div class="dashboard_container my-5" id="dashboard_container">
        <div class="container">
        <center><h2>Dashboard</h2></center>
        <br>
        <br>
            <div class="row justify-content-center">
                <div class="card custom_card mx-3 rounded" style="width: 18rem;">
                    <div class="card-body mx-5 my-5">
                        <center><h1 class="card-title">${cantidadCuentas}</h1></center>
                        <center><h5 class="card-subtitle mb-2 text-muted">Cuentas activas</h5></center>
                    </div>
                </div>
                <div class="card custom_card mx-3" style="width: 18rem;">
                    <div class="card-body mx-5 my-5">
                        <center><h1 class="card-title">${cantidadClientes}</h1></center>
                        <center><h5 class="card-subtitle mb-2 text-muted">Clientes activos</h5></center>
                    </div>
                </div>
                <div class="card custom_card mx-3" style="width: 18rem;">
                    <div class="card-body mx-5 my-5">
                        <center><h1 class="card-title">${cantidadTransacciones}</h1></center>
                        <center><h5 class="card-subtitle mb-2 text-muted">Transacciones realizadas</h5></center>
                    </div>
                </div>
            </div>
            </div>
        </div>
    </div>
</body>
</html>

