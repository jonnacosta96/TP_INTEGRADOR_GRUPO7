<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Client</title>
    <base href="/">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/x-icon" href="favicon.ico">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>	
    
    <div style="background-color: #e9ecef; min-height:94vh!important" class="container-fluid py-3" >
        <div></div>
        <div class="dashboard_container my-5" id="dashboard_container">
            <div class="row justify-content-center">
                <div class="card custom_card mx-3" style="width: 18rem;">
                    <div class="card-body">
                        <h1 class="card-title">125</h1>
                        <h6 class="card-subtitle mb-2 text-muted">Clientes</h6>
                        <a onclick="Lib.Collocations.Dashboard.ViewList()" class="card-link text-primary">Ver Lista</a>
                    </div>
                </div>
                <div class="card custom_card mx-3" style="width: 18rem;">
                    <div class="card-body">
                        <h1 class="card-title">153</h1>
                        <h6 class="card-subtitle mb-2 text-muted">Cuentas</h6>
                        <a onclick="Lib.Collocations.Dashboard.ViewList()" class="card-link text-primary">Ver Lista</a>
                    </div>
                </div>
                <div class="card custom_card mx-3" style="width: 18rem;">
                    <div class="card-body">
                        <h1 class="card-title">2103</h1>
                        <h6 class="card-subtitle mb-2 text-muted">Transacciones hoy</h6>
                        <a onclick="Lib.Collocations.Dashboard.ViewList()" class="card-link text-primary">Ver Lista</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

