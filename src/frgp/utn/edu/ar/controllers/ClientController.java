package frgp.utn.edu.ar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {
	@RequestMapping("transferir.html")
	public ModelAndView eventLoadPage() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("transferir");
		
		return mv;
	}
}
