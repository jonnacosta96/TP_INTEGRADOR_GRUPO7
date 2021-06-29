<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href="./css/glyphicon.css" type="text/css"/>
	<link rel="stylesheet" href="./css/table.css" type="text/css"/>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
    <script src="jquery-3.5.1.min.js"></script>

<title>UTN Banking 2021</title>
</head>

<body>
	
	<jsp:include page="header.jsp"></jsp:include>
	<div style="background-color: #e9ecef; min-height:94vh!important" class="container-fluid py-3" >
        <div class="container">
            <h2>Editar Cuenta</h2>
            <br>
            <form:form id="modificarCuentaForm" action="editarCuenta.html" method="post" modelAttribute="cuentaEditar">
              <div class="border border-dark mb-4 px-5 py-3 pb-5 rounded">
                <div class="row">
                  <div class="col">
                    <h5><label for="exampleInputEmail1">Cliente</label></h5>
                    <input type="text" class="form-control d-inline disabled" readonly 
                    	placeholder="Cliente"
                    	id="nombreCliente"
                    	name="nombreCliente"
                    	path="nombreCliente"
                    	value="<c:out value="${nombreCliente}"/>"
                   	>
                  </div>
                  <div class="col">
                    <h5><label for="exampleInputEmail1">Numero de cuenta</label></h5>
                    <input type="text" class="form-control d-inline disabled" readonly
                    	placeholder="Cliente"
                    	id="nroCuenta"
                    	name="nroCuenta"
                    	path="nroCuenta"
                    	value="<c:out value="${nroCuenta}"/>"
                   	>
                  </div>
                </div>
                <br>
                <div class="row">
                	<div class="col">
                	<h5><label for="exampleInputEmail1">Tipo</label></h5>
                    <input type="text" class="form-control d-inline disabled" readonly 
                    	placeholder="Tipo de cuenta"
                    	id="tipoCuenta"
                    	name="tipoCuenta"
                    	path="tipoCuenta"
                    	value="<c:out value="${tipoCuenta}"/>"
                   	>
                	</div>
                  <div class="col">
                    <h5><label for="exampleInputEmail1">Nombre</label></h5>
                    <input type="text" class="form-control d-inline" 
                    	placeholder="Nombre de cuenta"
                    	id="nombreCuenta"
                    	name="nombreCuenta"
                    	path="nombreCuenta"
                    	value="<c:out value="${nombreCuenta}"/>"
                   	>
                   	<p class="text-danger" id="cuentaNombreMessage">${errorNombreCuenta}</p>
                  </div>
                </div>
              </div>
              <p class="text-danger" id="cuentaNombreMessage">${error}</p>
              	<input type="hidden" name="returnUrl" value="${returnUrl}">
              	<button class="btn btn-dark d-inline" href="${pageContext.servletContext.contextPath}/guardarCuenta">Guardar</button>
              	<c:choose>
				    <c:when test="${returnUrl=='adminCuentas'}">
				        <a class="mx-3" href="${pageContext.servletContext.contextPath}/adminCuentas.html">Cancelar</a>
				    </c:when>    
				    <c:when test="${returnUrl=='modificarCliente'}">
				        <a class="mx-3" href="${pageContext.servletContext.contextPath}/accionCliente.html?nroCliente=${nroCliente}&btnModificarCli=">Cancelar</a>
				    </c:when>
				</c:choose>
              </form:form>
            
        </div>
    </div>

</body>
</html>

<script type="text/javascript">
	$('#nombreCuenta').keydown(function(){
			
			if($("#nombreCuenta").val().length >= 50 ){
				$('#cuentaNombreMessage').text("Ingrese un nombre de menos de 50 caracteres.");
				return;
			}
			else{
				$('#cuentaNombreMessage').text("");
			}
		}
		
	);
</script>