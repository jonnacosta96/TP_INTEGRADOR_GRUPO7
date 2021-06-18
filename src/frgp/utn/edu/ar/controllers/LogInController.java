package frgp.utn.edu.ar.controllers;

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
	
	@RequestMapping("adminHome.html")
	public ModelAndView eventLogInPage() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminHome");
		
		return mv;
	}
}
