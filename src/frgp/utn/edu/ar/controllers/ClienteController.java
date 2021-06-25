package frgp.utn.edu.ar.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Localidad;
import frgp.utn.edu.ar.entidades.Pais;
import frgp.utn.edu.ar.entidades.Provincia;
import frgp.utn.edu.ar.entidades.Usuario;
import frgp.utn.edu.ar.negocioImpl.ClienteNegImpl;

@Controller
public class ClienteController {

	@RequestMapping("listadoClientes.html")
	public ModelAndView LoadListClients() {
		
		ModelAndView mv = new ModelAndView();
		
		ClienteNegImpl cliNegImpl = new ClienteNegImpl();
		
		List<Cliente> lista = cliNegImpl.ObtenerListadoClientes(true);
		
		mv.addObject("ListaClientes", lista);
		
		mv.setViewName("adminClientes");
		
		return mv;
	}
	
	@RequestMapping("altaCliente24.html")
	public ModelAndView createNewClient(String txtNombre, String txtApellido,String txtDni, String flexRadioDefault,int cmbBoxProvincias ) {
		
		ModelAndView mv = new ModelAndView();
		
		Cliente cli = new Cliente();

		mv.setViewName("adminClientes");
		
		return mv;
	}
	
	@RequestMapping("altaCliente.html")
	 public String submit(@Validated @ModelAttribute("Cliente")Cliente cli, BindingResult result, ModelMap model, @RequestParam String cmbBoxLocalidades, @RequestParam String cmbBoxProvincias, @RequestParam String cmbBoxPaises, @RequestParam String fechaNac,@RequestParam String email) 
	{
	    if (result.hasErrors()) {
	        return "error";
	    }
	    
	    cli.setNroCliente(9999);
	    cli.setFechaNacimiento(LocalDate.parse(fechaNac));
	    cli.setPais(new Pais(Integer.parseInt(cmbBoxPaises.split("-")[0]), cmbBoxPaises.split("-")[1], true));
	    cli.setProv(new Provincia(Integer.parseInt(cmbBoxProvincias.split("-")[0]), cmbBoxProvincias.split("-")[1], true));
	    cli.setLoc(new Localidad(Integer.parseInt(cmbBoxLocalidades.split("-")[0]), cmbBoxLocalidades.split("-")[1], true));
	    cli.setEstadoCliente(true);
	    
	    String name = cli.getNombre().substring(0, 1) + cli.getApellido() + cli.getNroCliente();
	    String pass = String.valueOf(cli.getDni());
	    Usuario usu = new Usuario(name, pass, email, "Customer", true);
	    
	    cli.setUsuario(usu);
	    
	    ClienteNegImpl cliNegImpl = new ClienteNegImpl();
	    
	    boolean resultadoGuardado = cliNegImpl.GuardarCliente(cli);

	    return "adminClientes";
	}
}
