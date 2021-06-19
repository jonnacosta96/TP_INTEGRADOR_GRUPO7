package frgp.utn.edu.ar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.dao.Conexion;

@Controller
public class LogInController {

	@RequestMapping("index.html")
	public ModelAndView eventLoadPage() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		
		return mv;
	}
	
	@RequestMapping("validarIngreso.html")
	public ModelAndView eventLogInPage(String txtUsuario) {
		
		ModelAndView mv = new ModelAndView();
		Conexion cn = new Conexion();
		cn.abrirConexion();
		cn.cerrarSession();
		
		if(txtUsuario.toUpperCase().equals("CLIENTE"))
		{
			mv.setViewName("clienteHome");
		}
		else
		{
			mv.setViewName("adminHome");
		}
		
		
		return mv;
	}
}
