<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<link rel="stylesheet" href="./css/table.css" type="text/css"/>
		<link rel="stylesheet" href="./css/glyphicon.css" type="text/css"/>
		
	    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <title>UTN Banking 2021</title>
    <base href="/">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <jsp:include page="headerCliente.jsp"></jsp:include>	
    
    <div style="background-color: #e9ecef; min-height:94vh!important" class="container-fluid py-3" >
        <div class="dashboard_container my-5" id="dashboard_container">
            <div class="row justify-content-center">
                <div class="card custom_card mx-3" style="width: 18rem;">
                    <div class="card-body">
                        <h3 class="card-title">$80.025,62</h3>
                        <h6 class="card-subtitle mb-2 text-muted">Caja Vacaciones - CA ARS</h6>
                        <a onclick="Lib.Collocations.Dashboard.ViewList()" class="card-link text-primary">Ver Movimientos</a>
                    </div>
                </div>
                <div class="card custom_card mx-3" style="width: 18rem;">
                    <div class="card-body">
                        <h3 class="card-title">$10.025,62</h3>
                        <h6 class="card-subtitle mb-2 text-muted">Ahorros - CA ARS</h6>
                        <a onclick="Lib.Collocations.Dashboard.ViewList()" class="card-link text-primary">Ver Movimientos</a>
                    </div>
                </div>
                <div class="card custom_card mx-3 rounded" style="width: 18rem;">
                    <div class="card-body">
                        <h3 class="card-title">U$D45,50</h3>
                        <h6 class="card-subtitle mb-2 text-muted">Ahorros Dolar - CA USD</h6>
                        <a onclick="Lib.Collocations.Dashboard.ViewList()" class="card-link text-primary">Ver Movimientos</a>
                    </div>
                </div>
                <div class="card custom_card mx-3 rounded" style="width: 18rem;">
                    <div class="card-body">
                        <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/transferir.html">Transferir</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <h4>Ultimos movimientos de Caja vacaciones</h4>
            <table class="table my-5">
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">Cliente</th>
                    <th scope="col">Fecha creacion</th>
                    <th scope="col">Saldo</th>
                    <th scope="col">Estado</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                  </tr>
                  <tr>
                    <th scope="row">2</th>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                    <td>@fat</td>
                    <td>@fat</td>
                  </tr>
                  <tr>
                    <th scope="row">3</th>
                    <td>Larry</td>
                    <td>the Bird</td>
                    <td>@twitter</td>
                    <td>@twitter</td>
                    <td>@twitter</td>
                  </tr>
                </tbody>
              </table>
        </div>
    </div>
</body>
</html>