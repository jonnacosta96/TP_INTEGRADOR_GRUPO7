<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href="./css/table.css" type="text/css"/>
	
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<title>UTN Banking 2021</title>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>	
    
    <div style="background-color: #e9ecef; min-height:94vh!important" class="container-fluid py-3" >
        <div class="container">
        	<div>
        		<h2>Administrar Cuentas</h2>
        	</div>
            <br>
			<div class="row">
				<div class="col-md-6">
				    <div class="input-group">
				        <input type="text" class="form-control" placeholder="Numero de cuenta/Nombre cliente"name="txtApellido" pattern="[A-Za-z]*{1,30}" title="Solo se admiten Letras sin caracteres especiales. Tamaño mínimo: 1. Tamaño máximo: 30" required>
						<span class="input-group-btn">
							<input type="submit"  class="btn btn-dark" value="Buscar" name="btnBuscarCliente">
					    </span>
				    </div>
				</div>
			</div>
		    <div class="row">
		        <div class="col-md-12">                                
		            <br />
		            <p><a href="${pageContext.servletContext.contextPath}/crearCuenta.html" style="color: #337ab7">Crear Cuenta</a></p>
		            <p><a href="${pageContext.servletContext.contextPath}/modificarCuenta.html" style="color: #337ab7">Modificar Cuenta</a></p>
		        </div>
		    </div>
			<br>
            <div>
            	<table class="blueTable">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nombrede cuenta</th>
							<th>Nombre del cliente</th>
							<th>Tipo de cuenta</th>
							<th>Saldo</th>
							<th>CBU</th>
							<th>Accion</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<td colspan="7">
								<div class="links">
									<a href="#">&laquo;</a>
									<a class="active" href="#">1</a>
									<a href="#">2</a>
									<a href="#">3</a>
									<a href="#">4</a>
									<a href="#">&raquo;</a>
								</div>
							</td>
						</tr>
					</tfoot>
					<tbody>
						<tr>
							<td>100001</td>
							<td>CA Vacaciones</td>
							<td>Olea Tobias</td>
							<td>CA-ARS</td>
							<td>108.250,65</td>
							<td>1234567891324567891234</td>
							<td>
								<button class="btn btn-secondary btn-sm" href="${pageContext.servletContext.contextPath}/modificarCuenta">Modificar</button>
								<button class="btn btn-danger btn-sm" href="${pageContext.servletContext.contextPath}/eliminarCuenta">Eliminar</button>
							</td>
						</tr>
						<tr>
							<td>100001</td>
							<td>CA Inversioness</td>
							<td>Costa Jonathan</td>
							<td>CA-USD</td>
							<td>8.250,65</td>
							<td>2234567891324567891234</td>
							<td>
								<button class="btn btn-secondary btn-sm" href="${pageContext.servletContext.contextPath}/adminClientes.html">Modificar</button>
								<button class="btn btn-danger btn-sm" href="${pageContext.servletContext.contextPath}/adminClientes.html">Eliminar</button>
							</td>
						</tr>
					</tbody>
				</table>
            </div>	 	
        </div>
    </div>
</body>
</html>
