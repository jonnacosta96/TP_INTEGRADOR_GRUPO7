<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="utf-8">
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	    <link rel="stylesheet" href="./css/glyphicon.css" type="text/css"/>
		<link rel="stylesheet" href="./css/table.css" type="text/css"/>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	    
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
		<script type="text/javascript" src="./js/Alertas.js"></script>
    <title>UTN Banking 2021</title>
    <base href="/">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>	
    
   	 <c:choose>
	     <c:when test="${not empty errorEnModif}">
	         <script type="text/javascript">ModificacionFallida()</script>
	     </c:when>
	 </c:choose>
	 <c:choose>
	     <c:when test="${not empty avisoSuccess}">
	         <script type="text/javascript">
	        	SuccessMessage("${avisoSuccess}")
	         </script>
	     </c:when>
	     <c:when test="${not empty avisoError}">
	         <script type="text/javascript">
	         	ErrorMessage("${avisoError}")
	         </script>
	     </c:when>
	 </c:choose>
	  
	 
    <div style="background-color: #e9ecef; min-height:94vh!important" class="container-fluid py-3" >
        <div class="container">
			<h2>Modificar Cliente</h2>
            <br>
              <div class="border border-dark mb-4 px-5 py-3 pb-5 rounded">
               <div class="row">
                <div class="col">
           			<center></center><p class="text-danger">${errorFaltanCampos}</td></center>       
                </div>
              </div> 
              <form:form method="POST" action="${pageContext.servletContext.contextPath}/modificarCliente.html" modelAttribute="Cliente">
              <form:hidden path="nroCliente" value="${Cliente.nroCliente}" />
              <div class="row">
                <div class="col">
                  <h5><form:label path="nombre">Nombre</form:label></h5>
                  <form:input class="form-control" path="nombre" placeholder="Nombre" pattern="[A-Za-z]*{1,30}" title="Solo se admiten Letras sin caracteres especiales. Tama�o m�nimo: 1. Tama�o m�ximo: 30"/>      
                </div>
                <div class="col">
                  <h5><form:label path="apellido">Apellido</form:label></h5>
                  <form:input class="form-control" path="apellido" placeholder="Apellido" pattern="[A-Za-z]*{1,30}" title="Solo se admiten Letras sin caracteres especiales. Tama�o m�nimo: 1. Tama�o m�ximo: 30"/>    
                </div>
              </div>
              <br>
              <div class="row">
                <div class="col">
                  <h5><form:label path="dni">DNI</form:label></h5>
                  <form:input class="form-control" path="dni" value="" placeholder="DNI" pattern="[0-9]{1,10}" title="Solo se admiten N�meros. Tama�o m�nimo: 1. Tama�o m�ximo: 10"/>  
                  <p class="text-danger" id="dniMessage">${dniMessage}</p>
                </div>
                
                <div class="col">
                	<h5><form:label path="sexo">Genero</form:label></h5>
                    <form:radiobutton path="sexo" value="Femenino"/>
            		<label class="form-check-label">
					    Femenino
					</label>
					 
					<form:radiobutton path="sexo" value="Masculino"/>
				  	<label class="form-check-label">
					    Masculino
				  	</label>
                </div>
              </div>
              <br>
              <div class="row">
                <div class="col">     
                 	<h5><label for="exampleInputEmail1">Nacionalidad</label></h5>
					<select name="cmbBoxPaises" class="form-control"  required>
						<option value="">Seleccione Pais</option>
						<c:forEach items="${ListaPaises}" var="objpais">
							<c:choose>
							    <c:when test="${objpais.idPais == Cliente.pais.idPais}">
						        	<option value="${objpais.idPais}-${objpais.nombre}" selected="selected">${objpais.nombre}</option> 
							    </c:when>    
							    <c:otherwise>
							        <option value="${objpais.idPais}-${objpais.nombre}">${objpais.nombre}</option> 
							        <br />
							    </c:otherwise>
							</c:choose>
						</c:forEach>		
					</select>	 
                </div>
                <div class="col">
                  <h5><label for="exampleInputEmail1">Fecha de nacimiento</label></h5>
                  <input class="form-control" placeholder="Nacimiento" name="fechaNac" min="1970-01-01" max="2030-12-31" step="1" type="date" value="${fechaNacimiento}" required>
                </div>
              </div>
              <br>
              <div class="row">
       			<div class="col">
       				<h5><label for="exampleInputEmail1">Provincia</label></h5>
              	    <select name="cmbBoxProvincias" class="form-control"  required>
		 		 		<option value="">Seleccione Provincia</option>
		 		 		<c:forEach items="${ListaProvincias}" var="objprov">
							<c:choose>
							    <c:when test="${objprov.idProvincia == Cliente.prov.idProvincia}">
						        	<option value="${objprov.idProvincia}-${objprov.nombre}" selected="selected">${objprov.nombre}</option> 
							    </c:when>    
							    <c:otherwise>
							        <option value="${objprov.idProvincia}-${objprov.nombre}">${objprov.nombre}</option> 
							        <br />
							    </c:otherwise>
							</c:choose>
				 		</c:forEach>	 	
			 		 </select>	  	 		
				</div>
				<div class="col">  
					 <h5><label for="exampleInputEmail1">Localidad</label></h5>           		
             		<select name="cmbBoxLocalidades" class="form-control"  required>
		 		 		<option value="">Seleccione Localidad</option>
		 		 		<c:forEach items="${ListaLocalidades}" var="objloc">
							<c:choose>
							    <c:when test="${objloc.idLocalidad == Cliente.loc.idLocalidad}">
						        	<option value="${objloc.idLocalidad}-${objloc.nombre}" selected="selected">${objloc.nombre}</option> 
							    </c:when>    
							    <c:otherwise>
							        <option value="${objloc.idLocalidad}-${objloc.nombre}">${objloc.nombre}</option> 
							        <br />
							    </c:otherwise>
							</c:choose>
				 		</c:forEach>
			 		 </select>	
				</div>
              </div>
              <div class="row">
                <div class="col">        
                  <h5><form:label path="direccion">Direccion</form:label></h5>
                  <form:input class="form-control" path="direccion" placeholder="Direccion" pattern="[A-Za-z]*{1,30}" title="Solo se admiten Letras sin caracteres especiales. Tama�o m�nimo: 1. Tama�o m�ximo: 30"/>      
                </div>
                <div class="col">
            		<h5><label for="txtEmail">Email:</label></h5>
			 		<input type="email" class="form-control" name="email" value="${email}" required> 
                </div>
              </div>
              <br>
              <br>
              <button type="submit" class="btn btn-dark d-inline">Actualizar cliente</button>
              <a class="mx-3" href="${pageContext.servletContext.contextPath}/listadoClientes.html">Cancelar</a>
              </form:form> 
            </div>
              <br>
              <br>
              <div class="border border-dark mb-4 px-5 pb-5 rounded">
                <p>
                  <h3>
                    Cuentas asociadas
                  </h3>
                </p>
                <br>
                <table class="table my-3">
                  <thead class="thead-dark">
                    <tr>
                      <th scope="col">#</th>
                      <th scope="col">Fecha Creacion</th>
                      <th scope="col">Nombre</th>
                      <th scope="col">Tipo</th>
                      <th scope="col">Saldo</th>
                      <th scope="col">CBU</th>
                      <th scope="col" stlye="width:200px">Accion</th>
                    </tr>
                  </thead>
                  <tbody>
                  	
						<c:forEach items="${ListaCuentas}" var="cuentaObj">
						<form action="${pageContext.servletContext.contextPath}/accionCuenta.html" method="get">
							<tr>
								<th scope="col">${cuentaObj.nroCuenta}<input type="hidden" name="nroCuenta" value="${cuentaObj.nroCuenta}"></th>
								<th scope="col">${cuentaObj.fechaCreacion}</th>
								<th scope="col">${cuentaObj.nombre}</th>
								<th scope="col">${cuentaObj.tipoCuenta.nombre}</th>
								<th scope="col">${cuentaObj.saldo}</th>
								<th scope="col">${cuentaObj.CBU}</th>
								<td>
									<input type="hidden" name="returnUrl" value="modificarCliente">
									<button
											id="edit${cuentaObj.nroCuenta}"
											type="submit"
											name="modificarCuenta"
											class="btn btn-outline-secondary btn-sm"
										>
												<i class="fa fa-edit"></i>
										</button>
										<a
											id="delete${cuentaObj.nroCuenta}"
											name="eliminarCuenta"
											class="btn btn-outline-secondary btn-sm"
											onclick="
												document.getElementById('confirmDelete${cuentaObj.nroCuenta}').style.display = 'inline';
												document.getElementById('undoDelete${cuentaObj.nroCuenta}').style.display = 'inline';
												document.getElementById('delete${cuentaObj.nroCuenta}').style.display = 'none';
												document.getElementById('edit${cuentaObj.nroCuenta}').style.display = 'none';
											"
										>
												<i class="fa fa-trash"></i>
										</a>
										<button
											id="confirmDelete${cuentaObj.nroCuenta}"
											type="submit"
											style="display: none;"
											name="eliminarCuenta"
											class="btn btn-outline-secondary btn-sm"
										>
											Confirmar
										</button>
										<a
											id="undoDelete${cuentaObj.nroCuenta}"
											name="eliminarCuenta"
											style="display: none;"
											class="btn btn-outline-secondary btn-sm"
											onclick="
												document.getElementById('confirmDelete${cuentaObj.nroCuenta}').style.display = 'none';
												document.getElementById('undoDelete${cuentaObj.nroCuenta}').style.display = 'none';
												document.getElementById('delete${cuentaObj.nroCuenta}').style.display = 'inline';
												document.getElementById('edit${cuentaObj.nroCuenta}').style.display = 'inline';
											"
										>
											<i class="fa fa-undo"></i>
										</a>
								</td>
							</tr>
						</form>
						</c:forEach>
					
				</tbody>
                </table>
              
              <br>
                  <h3>
                    Crear cuenta
                  </h3>
                <br>
                <form:form id="crearCuentaForm" action="${pageContext.servletContext.contextPath}/guardarNuevaCuenta.html" method="post" modelAttribute="cuentaCrear">
                <div class="row">
                  <div class="col">
                  <input type="hidden" class="form-control d-inline disabled" readonly
                    	placeholder="Cliente"
                    	id="cantidadCuentas"
                    	name="cantidadCuentas"
                    	path="cantidadCuentas"
                    	value="<c:out value="${ListaCuentas}"/>"
                   	>
                  <input type="hidden" class="form-control d-inline disabled" readonly
                    	placeholder="Cliente"
                    	id="clienteId"
                    	name="clienteId"
                    	path="clienteId"
                    	value="<c:out value="${Cliente.nroCliente}"/>"
                   	>
                   	<input type="hidden" class="form-control d-inline disabled" readonly
                    	placeholder="Cliente"
                    	id="returnUrl"
                    	name="returnUrl"
                    	path="returnUrl"
                    	value="modificarCliente"
                   	>
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
                  <div class="row">
	                  <div class="col">
	             			<center></center><p class="text-danger">${error}</td></center>       
	                  </div>
	                </div>
                </div>
                <br>
                <button class="btn btn-dark d-inline">Guardar</button>
                <a class="mx-3" href="${pageContext.servletContext.contextPath}/listadoClientes.html">Cancelar</a>
                </form:form>
              </div>
              
        </div>
    </div>
</body>
</html>

<script type="text/javascript">
$('#crearCuentaForm').submit(function(event)
	{
		if($("#cantidadCuentas").val().match(/nroCuenta/g).length >= 4 )
		{
			$('#cuentaNombreMessage').text("El cliente ya tiene 4 cuentas asociadas");
			event.preventDefault();
			return;
		}
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
	}   
);
$('#cuentaNombre').keyup(function(){
	
	if($("#cuentaNombre").val().length > 50 ){
		$('#cuentaNombreMessage').text("Ingrese un nombre de hasta 50 caracteres.");
		return;
	}
	else{
		$('#cuentaNombreMessage').text("");
	}
}

);
</script>
