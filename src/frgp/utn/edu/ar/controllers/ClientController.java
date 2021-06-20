package frgp.utn.edu.ar.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.dto.UserSessionDto;
import helpers.ViewNameResolver;

@Controller
public class ClientController {
	
	
	@RequestMapping("clienteHome.html")
	public ModelAndView eventLoadPage(HttpSession httpSession, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		String viewName = ViewNameResolver.resolveViewName(
			(UserSessionDto)httpSession.getAttribute("userSession"),
			request.getServletPath()
		);
	    
	    mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping("transferir.html")
	public ModelAndView transferir(HttpSession httpSession, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		String viewName = ViewNameResolver.resolveViewName(
			(UserSessionDto)httpSession.getAttribute("userSession"),
			request.getServletPath()
		);
	    
	    mav.setViewName(viewName);
		return mav;
	}
}
