<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="frgp.utn.edu.ar.dto.CrearCuentaDto"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href="./css/glyphicon.css" type="text/css"/>
	<link rel="stylesheet" href="./css/table.css" type="text/css"/>
	
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
            <h2>Nueva Cuenta</h2>
            
            <br>
            <form:form id="crearCuentaForm" action="guardarNuevaCuenta.html" method="post" modelAttribute="cuentaCrear">
              <div class="border border-dark mb-4 px-5 py-3 pb-5 rounded">
              	<div class="row">
                  <div class="col">
                    <h5><label for="exampleInputEmail1">DNI Cliente</label></h5>
                    <div class="col-md-10">
					    <div class="input-group">
						    <div id="buscarClienteForm" action="#">
						        <span class="input-group-btn">
						        	<input type="number" class="form-control" placeholder="DNI Cliente" id="dni" class="form-control d-inline" style="width: 90%;">
									<input  type="button" id="buscarCliente" class="btn btn-dark" value="Buscar" class="form-control d-inline">
							    </span>
							    <p class="text-danger" id="dniMessage"></p>
						    </div>
					    </div>
					</div>
                  </div>
                  <div class="col">
                  	<h5><label for="exampleInputEmail1">Cliente</label></h5>
                    <input type="text" class="form-control d-inline disabled" readonly 
                    	placeholder="Cliente"
                    	id="clienteNombre"
                    	name="clienteNombre"
                    	path="clienteNombre"
                    	value="<c:out value="${parameters.clienteNombre}"/>"
                   	>
                    <input type="hidden" class="form-control d-inline disabled" readonly
                    	placeholder="Cliente"
                    	id="clienteId"
                    	name="clienteId"
                    	path="clienteId"
                    	value="<c:out value="${parameters.clienteId}"/>"
                   	>
                   	<input type="hidden" class="form-control d-inline disabled" readonly
                    	placeholder="Cliente"
                    	id="returnUrl"
                    	name="returnUrl"
                    	path="returUrl"
                    	value="<c:out value="${parameters.clienteId}"/>"
                   	>
                   	<center></center><p id="clienteMessage" class="text-danger">${error}</td></center>
                  </div>
                </div>
                <br>
                <div class="row">
                  <div class="col">
                    <h5><label for="exampleInputEmail1">Nombre de cuenta</label></h5>
                    <input type="text" class="form-control" placeholder="Nombre"
                    	id="cuentaNombre"
                    	name="cuentaNombre"
                    	path="cuentaNombre"
                    	value="<c:out value="${parameters.cuentaNombre}"/>"
                   	>
                    <p class="text-danger" id="cuentaNombreMessage">${errorNombreCuenta}</p>
                  </div>
                  <div class="col">
                    <h5><label for="exampleInputEmail1">Tipo</label></h5>
                    <select class="form-select form-control" aria-label="Default select example" name="tipoCuenta" path="tipoCuenta" id="tipoCuenta">
    					<c:forEach items="${tiposCuenta}" var="tipoCuenta">
					 		<option value="${tipoCuenta.codigo}">${tipoCuenta.nombre}</option>
				 		</c:forEach>
                    </select>
                  </div>
                </div>
                <div class="row">
                  <div class="col">
             			<center></center><p id="errorMessage" class="text-danger">${error}</td></center>       
                  </div>
                </div>               
              </div>
              	<button class="btn btn-dark d-inline" href="${pageContext.servletContext.contextPath}/guardarCuenta">Guardar</button>
              	<a class="btn btn-secondary d-inline" href="${pageContext.servletContext.contextPath}/adminCuentas.html">Cancelar</a>
             </form:form>
        </div>
    </div>

</body>
</html>


<script type="text/javascript">
$('#buscarCliente').on('click',
	function()
	{
		var regExp = new RegExp("\\b[0-9]{7,8}\\b")
		if(!regExp.test($("#dni").val())){
			$('#dniMessage').text("Por favor, ingrese un numero de 7 u 8 digitos");
			return;
		}
			
		$.ajax({
		    type : "GET",
		    url : "buscarCliente.html",
		    data : {
		    	"dni" : $("#dni").val()
		    },
		    success: function(data){
		    	var json = JSON.parse(data);
		    	if(json.result == "error")
	    		{
		    		$('#dniMessage').text(json.error);
	    		}
		    	else
	    		{
		    		$('#dniMessage').text("");
		    		$("#clienteNombre").val(json.nombre);
		    		$("#clienteId").val(json.id);
	    		}
		    }
		})
	}   
);
$('#cuentaNombre').keyup(function(){
		
		if($("#cuentaNombre").val().length == 51 ){
			$('#cuentaNombreMessage').text("Ingrese un nombre de hasta 50 caracteres.");
			return;
		}
		if($("#cuentaNombre").val().length <= 50 ){
			$('#cuentaNombreMessage').text("");
		}
	}
	
);
$('#crearCuentaForm').submit(function(event)
		{
			if($("#cuentaNombre").val().length > 50 ){
				$('#cuentaNombreMessage').text("Ingrese un nombre de hasta 50 caracteres");
				event.preventDefault();
				return;
			}
			if($("#cuentaNombre").val().length == 0 )
			{
				$('#cuentaNombreMessage').text("Ingrese un nombre");
				event.preventDefault();
				return;
			}
			if($("#clienteId").val().length == 0 )
			{
				$('#clienteMessage').text("Seleccione un cliente");
				event.preventDefault();
				return;
			}
		}   
	);
</script>