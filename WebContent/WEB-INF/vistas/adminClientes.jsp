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
	<link rel="stylesheet" href="./css/table.css" type="text/css"/>
	
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	<script type="text/javascript" src="./js/jquery.configTables.min.js"></script>
	<script type="text/javascript">
		$(document).ready( function () {
		$("#TablaClientes").DataTable();
		} );
	</script>
	
	<title>UTN Banking 2021</title>
</head>

<body>
	
	<jsp:include page="header.jsp"></jsp:include>	
    <div style="background-color: #e9ecef; min-height:94vh!important" class="container-fluid py-3" >
        <div class="container">
        	<div>
        		<h2>Administrar Clientes</h2>
        	</div>
            <%--
			<div class="row">
				<div class="col-md-6">
				    <div class="input-group">
				        <span class="input-group-addon"><i class="glyphicon glyphicon-search" style="font-size: small"></i></span>
				        <input type="text" class="form-control" placeholder="Usuario/DNI"name="txtApellido" pattern="[A-Za-z]*{1,30}" title="Solo se admiten Letras sin caracteres especiales. Tama�o m�nimo: 1. Tama�o m�ximo: 30" required>
						<span class="input-group-btn">
							<input type="submit"  class="btn btn-dark" value="Buscar" name="btnBuscarCliente">
					    </span>
				    </div>
				</div>
			</div>--%>
		    <div class="row">
		        <div class="col-md-12">                                
		            <br/>           
		            <p><a href="${pageContext.servletContext.contextPath}/crearCliente.html" style="color: #337ab7"><i class="glyphicon glyphicon-user" style="color: #337ab7"></i>Crear Cliente</a></p>
		        	<p><a href="${pageContext.servletContext.contextPath}/modificarCliente.html" style="color: #337ab7">Modificar Cliente</a></p>
		        </div>
		    </div>
			<br>
            <div>
            	<table id="TablaClientes" class="blueTable">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nombre</th>
							<th>Apellido</th>
							<th>DNI</th>
							<th>Fecha Nacimiento</th>
							<th>Sexo</th>
							<th>Direccion</th>
							<th>Pais</th>
							<th>Provincia</th>
							<th>Localidad</th>
							<th>Accion</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<td colspan="11">
							</td>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach items="${ListaClientes}" var="objcli">
							<tr>
								<td>${objcli.nroCliente}</td>
								<td>${objcli.nombre}</td>
								<td>${objcli.apellido}</td>
								<td>${objcli.dni}</td>
								<td>${objcli.sexo}</td>
								<td>${objcli.sexo}</td>
								<td>${objcli.pais.nombre}</td>
								<td>${objcli.prov.nombre}</td>
								<td>${objcli.loc.nombre}</td>
								<td>${objcli.direccion}</td>
								<td><button type="button" class="btn btn-secondary btn-sm">Modificar</button><button type="button" class="btn btn-danger btn-sm">Eliminar</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
            </div>	 	
        </div>
    </div>
</body>
</html>