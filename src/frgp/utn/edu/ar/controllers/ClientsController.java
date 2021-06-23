package frgp.utn.edu.ar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;

import frgp.utn.edu.ar.dao.Conexion;

@Controller
public class ClientsController {

	@RequestMapping("listadoClientes.html")
	public ModelAndView LoadListClients() {
		
		ModelAndView mv = new ModelAndView();
		
		
		
		return mv;
	}
}
