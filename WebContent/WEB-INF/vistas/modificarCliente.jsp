<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		
	    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <title>UTN Banking 2021</title>
    <base href="/">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>	
    
    <div style="background-color: #e9ecef; min-height:94vh!important" class="container-fluid py-3" >
        <div class="container">
            <h2>Modificar Cliente</h2>
            <br>
            <form>
              <div class="border border-dark mb-4 px-5 py-4 rounded">
                <div class="row">
	                <div class="col">
	                  <h5><label for="txtLegajo">Nro Cliente</label></h5>
	                  <input class="form-control col-2" type="text"  name="txtLegajo" maxlength="6" value="1001" readonly="readonly">	
	                </div>
                </div>
                <br>
                <div class="row">
	                <div class="col">
	                  <h5><label for="txtNombre">Nombre</label></h5>
	                  <input type="text" class="form-control" placeholder="Nombre" name="txtNombre" pattern="[A-Za-z]*{1,30}" title="Solo se admiten Letras sin caracteres especiales. Tamaño mínimo: 1. Tamaño máximo: 30" required>
	                </div>
	                <div class="col">
	                  <h5><label for="txtApellido">Apellido</label></h5>
	                  <input type="text" class="form-control" placeholder="Apellido" name="txtApellido" pattern="[A-Za-z]*{1,30}" title="Solo se admiten Letras sin caracteres especiales. Tamaño mínimo: 1. Tamaño máximo: 30" required>
	                </div>
                </div>
                <br>
                <div class="row">
	                <div class="col">
	                  <h5><label for="txtDni">DNI</label></h5>
	                  <input type="text" class="form-control" placeholder="DNI" name="txtDni" pattern="[0-9]{1,10}" title="Solo se admiten Números. Tamaño mínimo: 1. Tamaño máximo: 10" required >
	                </div>
                  <div class="col">
                    <div class="form-group">
                      <h5><label for="exampleInputPassword1">Genero</label></h5>
                      <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                        <label class="form-check-label" for="flexRadioDefault1">
                          Femenino
                        </label>
                      </div>
                      <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
                        <label class="form-check-label" for="flexRadioDefault2">
                          Masculino
                        </label>
                      </div>
                    </div>
                  </div>
                </div>
                <br>
                <div class="row">
	                <div class="col">
	                  <h5><label for="txtNacionaliad">Nacionalidad</label></h5>
	                  <input type="text" class="form-control" placeholder="Nacionalidad" name="txtNacionaliad" pattern="[A-Za-z]*{1,30}" title="Solo se admiten Letras sin caracteres especiales. Tamaño mínimo: 1. Tamaño máximo: 30" required>
	                </div>
	                <div class="col">
	                  <h5><label for="fechaNacimiento">Fecha de nacimiento</label></h5>
	                  <input type="date" class="form-control" placeholder="Nacimiento" name="fechaNacimiento" min="1970-01-01" max="2030-12-31" step="1" required>	
	                </div>
                </div>
                <br>
                <div class="row">
	       			<div class="col">
				 		<h5><label for="cmbBoxProvincias">Provincia</label></h5>
				  		 <select name="cmbBoxProvincias"  class="form-control" required>
				  		 		<option value="">Seleccione Provincia</option>
					  		 	<option value="1">Buenos Aires</option>
								<option value="2">Santa Fe</option>
								<option value="3">Mendoza</option>
				  		 </select>		 		
					</div>
					<div class="col">
				  		 <h5><label for="cmbBoxLocalidades">Localidad:</label></h5>
				 		 <select name="cmbBoxLocalidades" class="form-control"  required>
				 		 		<option value="">Seleccione Localidad</option>
						 		<option value="1">Don Torcuato</option>
						 		<option value="2">San Fernando</option>
						 		<option value="3">Pacheco</option>
				 		 </select>
					</div>
                </div>
                <br>
                <br>
                <button type="submit" class="btn btn-primary d-inline">Actualizar cliente</button>
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
                  <thead>
                    <tr>
                      <th scope="col">#</th>
                      <th scope="col">Fecha Creacion</th>
                      <th scope="col">Nombre</th>
                      <th scope="col">Cliente</th>
                      <th scope="col">Tipo</th>
                      <th scope="col">Saldo</th>
                      <th scope="col">CBU</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">1</th>
                      <td>12/05/1997</td>
                      <td>CA1 - User Prueba</td>
                      <td>1000123</td>
                      <td>Caja Ahorro ARS</td>
                      <td>85.468,26</td>
                      <td>1234567891234567891234</td>
                    </tr>
                  </tbody>
                </table>
              <br>
                <p>
                  <h3>
                    Crear cuenta
                  </h3>
                </p>
                <br>
                <div class="row">
                  <div class="col">
                    <h5><label for="NombreCuenta">Nombre de cuenta</label></h5>
                    <input type="text" class="form-control" placeholder="NombreCuenta" name="txtNombreCta" pattern="[0-9]{1,20}" title="Solo se admiten Números. Tamaño mínimo: 1. Tamaño máximo: 20" required >
                  </div>
                  <div class="col">
                    <h5><label for="cmbBoxTiposCtas">Tipo</label></h5>
                    <select class="form-select form-control" name="cmbBoxTiposCtas" aria-label="Default select example">
                      <option selected>Caja de ahorro ARS</option>
                      <option value="1">Caja de ahorro USD</option>
                    </select>
                  </div>
                </div>
                <br>
                <button type="submit" class="btn btn-dark d-inline">Guardar Cuenta</button>
              </div>
            </form>
        </div>
    </div>
</body>
</html>