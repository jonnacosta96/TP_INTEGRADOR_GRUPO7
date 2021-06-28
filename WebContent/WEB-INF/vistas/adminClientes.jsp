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
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript" src="./js/Alertas.js"></script>
	
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
	
	 <c:choose>
	     <c:when test="${not empty msgAlta}">
	         <script type="text/javascript">InformarUsuarioCliente("${msgAlta}")</script>
	     </c:when>
	 </c:choose>
 	 <c:choose>
	     <c:when test="${not empty eliminacionExitosa}">
	         <script type="text/javascript">EliminacionExitosa("Cliente")</script>
	     </c:when>
	 </c:choose>
   	 <c:choose>
	     <c:when test="${not empty eliminacionFallida}">
	         <script type="text/javascript">EliminacioncionFallida()</script>
	     </c:when>
	 </c:choose>   
   	 <c:choose>
	     <c:when test="${not empty msgModificacion}">
	         <script type="text/javascript">ModificacionExitosa("Cliente")</script>
	     </c:when>
	 </c:choose>  

    <div style="background-color: #e9ecef; min-height:94vh!important" class="container-fluid py-3" >
        <div class="container">
        	<div>
        		<h2>Administrar Clientes</h2>
        	</div>
		    <div class="row">
		        <div class="col-md-12">                                
		            <br/>           
		            <p><a href="${pageContext.servletContext.contextPath}/crearCliente.html" style="color: #337ab7"><i class="glyphicon glyphicon-user" style="color: #337ab7"></i>Crear Cliente</a></p>
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
							<th style="width:200px;">Accion</th>
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
								<form action="${pageContext.servletContext.contextPath}/accionCliente.html" method="get">
									<td>${objcli.nroCliente}<input type="hidden" name="nroCliente" value="${objcli.nroCliente}"></td>
									<td>${objcli.nombre}</td>
									<td>${objcli.apellido}</td>
									<td>${objcli.dni}</td>
									<td>${objcli.fechaNacimiento}</td>
									<td>${objcli.sexo}</td>
									<td>${objcli.direccion}</td>
									<td>${objcli.pais.nombre}</td>
									<td>${objcli.prov.nombre}</td>
									<td>${objcli.loc.nombre}</td>
									<td>
										<input type="hidden" name="returnUrl" value="adminCuentas">
										<button
											id="edit${objcli.nroCliente}"
											type="submit"
											name="btnModificarCli"
											class="btn btn-outline-secondary btn-sm"
										>
												<i class="fa fa-edit"></i>
										</button>
										<a
											id="delete${objcli.nroCliente}"
											name="eliminarCuenta"
											class="btn btn-outline-secondary btn-sm"
											onclick="
												document.getElementById('confirmDelete${objcli.nroCliente}').style.display = 'inline';
												document.getElementById('undoDelete${objcli.nroCliente}').style.display = 'inline';
												document.getElementById('delete${objcli.nroCliente}').style.display = 'none';
												document.getElementById('edit${objcli.nroCliente}').style.display = 'none';
											"
										>
												<i class="fa fa-trash"></i>
										</a>
										<button
											id="confirmDelete${objcli.nroCliente}"
											type="submit"
											style="display: none;"
											name="btnEliminarCli"
											class="btn btn-outline-secondary btn-sm"
										>
											Confirmar
										</button>
										<a
											id="undoDelete${objcli.nroCliente}"
											name="eliminarCuenta"
											style="display: none;"
											class="btn btn-outline-secondary btn-sm"
											onclick="
												document.getElementById('confirmDelete${objcli.nroCliente}').style.display = 'none';
												document.getElementById('undoDelete${objcli.nroCliente}').style.display = 'none';
												document.getElementById('delete${objcli.nroCliente}').style.display = 'inline';
												document.getElementById('edit${objcli.nroCliente}').style.display = 'inline';
											"
										>
											<i class="fa fa-undo"></i>
										</a>
									</td>
								</form>
							</tr>
						</c:forEach>
					</tbody>
				</table>
            </div>	 	
        </div>
    </div>
</body>
</html>