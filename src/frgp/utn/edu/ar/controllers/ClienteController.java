package frgp.utn.edu.ar.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.entidades.Cliente;
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
}
