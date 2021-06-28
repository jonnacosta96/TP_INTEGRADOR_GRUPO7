<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        		<c:forEach items="${listaCuentasCliente}" var="objCuenta">
	     			<div class="card custom_card mx-3" style="width: 18rem;">
	                   <div class="card-body">
	                       <h3 class="card-title">$ ${objCuenta.saldo}</h3>
	                       <h6 class="card-subtitle mb-2 text-muted">Nro: ${objCuenta.nroCuenta} - ${objCuenta.nombre}</h6>
	                       <h6 class="card-subtitle mb-1 text-muted">${objCuenta.tipoCuenta.nombre}</h6>
	                       <a href="${pageContext.servletContext.contextPath}/TransaccionesxCuenta.html?nroCuenta=${objCuenta.nroCuenta}" class="card-link text-primary" style="color: #337ab7">Ver Movimientos</a>
	                   </div>
	                </div>
		 		</c:forEach>
		 		
                <div class="card custom_card mx-3 rounded" style="width: 18rem; ">
                    <div class="card-body" style="display: flex; align-items: center; justify-content: center;">
                    	<a href="${pageContext.servletContext.contextPath}/transferir.html?nroCliente=${Cliente.nroCliente}" style="color: #337ab7"><i class="glyphicon glyphicon-usd" style="color: #337ab7"></i>Transferir</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <h4>Resumen de movimientos del Cliente</h4>
            <table class="table my-5">
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
                <tbody>
				  <c:forEach items="${ListaTransaccionesCliente}" var="objTransac">
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
    </div>
</body>
</html>