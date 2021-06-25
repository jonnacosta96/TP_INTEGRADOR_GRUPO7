<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
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
            <c:when test="${not empty msgError}">
                <script type="text/javascript">AltaFallida("Cliente")</script>
            </c:when>
        </c:choose>
        
    <div style="background-color: #e9ecef; min-height:94vh!important" class="container-fluid py-3" >
        <div class="container">
            <h2>Nuevo Cliente</h2>
            <br>
            <form:form method="POST" action="${pageContext.servletContext.contextPath}/altaCliente.html" modelAttribute="Cliente">
            <%--<form action="${pageContext.servletContext.contextPath}/altaCliente.html" method="get">--%>
              <div class="border border-dark mb-4 px-5 py-3 pb-5 rounded">
              <div class="row">
                <div class="col">
                  <h5><label for="txtLegajo">Nro Cliente</label></h5>
                  <input class="form-control col-2" type="text"  name="txtLegajo" maxlength="6" value="1001" readonly="readonly">	
                </div>
              </div>
              <br>
              <div class="row">
                <div class="col">
                
                  <h5><form:label path="nombre">Nombre</form:label></h5>
                  <form:input class="form-control" path="nombre" placeholder="Nombre" pattern="[A-Za-z]*{1,30}" title="Solo se admiten Letras sin caracteres especiales. Tamaño mínimo: 1. Tamaño máximo: 30"/>      
                </div>
                <div class="col">
                  <h5><form:label path="apellido">Apellido</form:label></h5>
                  <form:input class="form-control" path="apellido" placeholder="Apellido" pattern="[A-Za-z]*{1,30}" title="Solo se admiten Letras sin caracteres especiales. Tamaño mínimo: 1. Tamaño máximo: 30"/>    
                </div>
              </div>
              <br>
              <div class="row">
                <div class="col">
                  <h5><form:label path="dni">DNI</form:label></h5>
                  <form:input class="form-control" path="dni" value="" placeholder="DNI" pattern="[0-9]{1,10}" title="Solo se admiten Números. Tamaño mínimo: 1. Tamaño máximo: 10"/>  
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
							<option value="${objpais.idPais}-${objpais.nombre}">${objpais.nombre}</option>
						</c:forEach>
					</select>	 
                </div>
                <div class="col">
                  <h5><label for="exampleInputEmail1">Fecha de nacimiento</label></h5>
                  <input class="form-control" placeholder="Nacimiento" name="fechaNac" min="1970-01-01" max="2030-12-31" step="1" type="date" required>
                </div>
              </div>
              <br>
              <div class="row">
       			<div class="col">
       				<h5><label for="exampleInputEmail1">Provincia</label></h5>
              	    <select name="cmbBoxProvincias" class="form-control"  required>
		 		 		<option value="">Seleccione Provincia</option>
		 		 		<c:forEach items="${ListaProvincias}" var="objprov">
					 		<option value="${objprov.idProvincia}-${objprov.nombre}">${objprov.nombre}</option>
				 		</c:forEach>
			 		 </select>	  	 		
				</div>
				<div class="col">  
					 <h5><label for="exampleInputEmail1">Localidad</label></h5>           		
             		<select name="cmbBoxLocalidades" class="form-control"  required>
		 		 		<option value="">Seleccione Localidad</option>
		 		 		<c:forEach items="${ListaLocalidades}" var="objloc">
					 		<option value="${objloc.idLocalidad}-${objloc.nombre}">${objloc.nombre}</option>
				 		</c:forEach>
			 		 </select>	
				</div>
              </div>
              <div class="row">
                <div class="col">        
                  <h5><form:label path="direccion">Direccion</form:label></h5>
                  <form:input class="form-control" path="direccion" placeholder="Direccion" pattern="[A-Za-z]*{1,30}" title="Solo se admiten Letras sin caracteres especiales. Tamaño mínimo: 1. Tamaño máximo: 30"/>      
                </div>
                <div class="col">
            		<h5><label for="txtEmail">Email:</label></h5>
			 		<input type="email" class="form-control" name="email" required> 
                </div>
              </div>
            </div>
              <br>
              <br>
              <div class="border border-dark mb-4 px-5 py-3 pb-5 rounded">
                <p>
                  <h3>
                    Crear cuenta (opcional)
                  </h3>
                </p>
                <br>
                <div class="row">
                  <div class="col">
                    <h5><label for="NombreCuenta">Nombre de cuenta</label></h5>
                    <input type="text" class="form-control" placeholder="NombreCuenta" name="txtNombreCta" pattern="[A-Za-z]*{1,30}" title="Solo se admiten Números. Tamaño mínimo: 1. Tamaño máximo: 20" required >
                  </div>
                  <div class="col">
                    <h5><label for="cmbBoxTiposCtas">Tipo</label></h5>
                    <select class="form-select form-control" name="cmbBoxTiposCtas" aria-label="Default select example">
                      <option selected>Caja de ahorro ARS</option>
                      <option value="1">Caja de ahorro USD</option>
                    </select>
                  </div>
                </div>
              </div>
              <div>
              	<button type="submit" class="btn btn-success d-inline">Guardar</button>
              	<button type="submit" class="btn btn-primary d-inline">Volver</button>
              </div>
            </form:form>  
            <%--</form>--%>
        </div>
    </div>
</body>
</html>