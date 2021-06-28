<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href="./css/glyphicon.css" type="text/css"/>
	<link rel="stylesheet" href="./css/desingTable.css" type="text/css"/>
	<link rel="stylesheet" href="./css/table.css" type="text/css"/>
	
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	
	<script type="text/javascript" src="./js/jquery.configTables.min.js"></script>
	<script type="text/javascript">
		$(document).ready( function () {
		$("#TablaTransacciones").DataTable();
		} );
	</script>
	
	<title>UTN Banking 2021</title>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>	
	

    <div style="background-color: #e9ecef; min-height:94vh!important" class="container-fluid py-3" >
        <div class="container">
        	<div>
        		<h2>Movimientos de la Cuenta</h2>
        	</div>
			<br>
            <div>
            	<table id="TablaTransacciones" class="blueTable">
					<thead>
						<tr>
		                    <th scope="col">Nro Transac.</th>
		                    <th scope="col">Nro Cuenta y Nombre</th>
		                    <th scope="col">Descripcion</th>
		                    <th scope="col">Tipo</th>
		                    <th scope="col">Monto</th>
		                    <th scope="col">Fecha</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<td colspan="6">
							</td>
						</tr>
					</tfoot>
					<tbody>
					  <c:forEach items="${ListaTransaccionesCuenta}" var="objTransac">
						<tr>
							<td>${objTransac.idTransaccion}</td>
							<td>${objTransac.cuentaAsoc.nroCuenta} - ${objTransac.cuentaAsoc.nombre}</td>
							<td>${objTransac.descripcion}</td>
							<td>${objTransac.tipoTransaccion.descripcion}</td>
							<td>${objTransac.saldo}</td>
							<td>${objTransac.fechaTransaccion}</td>
						</tr>
					  </c:forEach>
					</tbody>
				</table>
            </div>
            <br>
            <div>
            <a class="btn btn-primary d-inline" href="${pageContext.servletContext.contextPath}/clienteHome.html">Volver</a>	
            </div>
             	
        </div>
    </div>
</body>
</html>