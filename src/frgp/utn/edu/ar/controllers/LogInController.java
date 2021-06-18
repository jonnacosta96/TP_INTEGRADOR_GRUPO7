package frgp.utn.edu.ar.controllers;

import org.apache.catalina.valves.rewrite.InternalRewriteMap.UpperCase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
