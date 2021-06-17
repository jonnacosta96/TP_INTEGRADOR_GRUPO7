package frgp.utn.edu.ar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@RequestMapping(value="adminClientes.html")
	public ModelAndView eventClickMenuClientes() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("adminClientes");
		
		return mv;
	}
	
	@RequestMapping(value="adminCuentas.html")
	public ModelAndView eventClickMenuCuentas() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("adminCuentas");
		
		return mv;
	}
}
