
function ConfirmarEliminacion() {
//Ingresamos un mensaje a mostrar
var mensaje = confirm("¿Esta seguro que desea eliminar el item seleccionado?");
//Detectamos si el usuario acepto el mensaje
if (mensaje) {
alert("¡Eliminado Correctamente!");
}
//Detectamos si el usuario denegó el mensaje
else {
alert("¡No se elimino!");
}
}


function AltaExitosa(itemAlta){
	swal({
		  title: "Alta Exitosa!",
		  text: "El " + itemAlta + " fue dado de Alta Correctamente.",
		  icon: "success",
		  button: "Aceptar",
		});
}

function ModificacionExitosa(itemModif){
	swal({
		  title: "Modificacion Exitosa!",
		  text: "El " + itemModif + " fue Modificado Correctamente.",
		  icon: "success",
		  button: "Aceptar",
		});
}

function EliminacionExitosa(itemEliminar){
	swal({
		  title: "Eliminacion Exitosa!",
		  text: "El " + itemEliminar + " fue Eliminado Correctamente.",
		  icon: "success",
		  button: "Aceptar",
		});
}

function AltaFallida(itemAlta){
	swal({
		  title: "Error en el Alta!",
		  text: "El " + itemAlta + " no pudo ser dado de Alta. Intente nuevamente en unos minutos.",
		  icon: "error",
		  button: "Aceptar",
		});
}

function ModificacionFallida(itemModif){
	swal({
		  title: "Error en la Modificacion!",
		  text: "El " + itemModif + " no pudo ser Modificado Correctamente. Intente nuevamente en unos minutos.",
		  icon: "error",
		  button: "Aceptar",
		});
}

function EliminacioncionFallida(itemEliminar){
	swal({
		  title: "Error en la Eliminacion!",
		  text: "El " + itemEliminar + " no pudo ser Eliminado Correctamente. Intente nuevamente en unos minutos.",
		  icon: "error",
		  button: "Aceptar",
		});
}

function InformarUsuarioCliente(msgAlta){
	swal({
		  title: "Usuario Cliente Creado Correctamente!",
		  text: msgAlta,
		  icon: "success",
		  button: "Ok",
		});
}

function UsuarioInexistente(){
	swal({
		  title: "Usuario Inexistente!",
		  text: "El usuario ingresado no existe.",
		  icon: "info",
		  button: "Ok",
		});
}

function ContraseniaIncorrecta(){
	swal({
		  title: "Contraseña Incorrecta!",
		  text: "La contraseña ingresada no es valida.",
		  icon: "info",
		  button: "Ok",
		});
}

function ElementoYaExiste(itemExiste){
	swal({
		  title: "El " + itemExiste + " Ingresado ya existe!",
		  text: "Ya se encuentra registrado un " + itemExiste + " con el dni ingresado. ",
		  icon: "warning",
		  button: "Ok",
		});
}


function validar(formulario){
	  swal({
          title: "There Is No Data To Display!",
          text: "You will return to the PR5 transaction page...",
          icon: "warning",
          button: "OK",
        })
        .then((value) => {
          if (value == true) {
        	  const hiddenField = formulario.createElement('input');
              hiddenField.type = 'hidden';
              hiddenField.name = ke;y
              hiddenField.value = params[key];
        	  formulario.method = "post";
        	  formulario.submit();

          }
        });
}

function AltaCuentaExitosa(itemAlta){
	swal({
		  title: "Alta exitosa",
		  text: "La cuenta " + itemAlta + " fue dada de alta correctamente.",
		  icon: "success",
		  button: "Aceptar",
		});
}


