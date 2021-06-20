package frgp.utn.edu.ar.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.dto.UserSessionDto;
import helpers.ViewNameResolver;


@Controller
public class AdminController {

	@RequestMapping(value="adminHome.html")
	public ModelAndView eventClickAdminHome(HttpSession httpSession, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		String viewName = ViewNameResolver.resolveViewName(
			(UserSessionDto)httpSession.getAttribute("userSession"),
			request.getServletPath()
		);
	    
	    mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="adminClientes.html")
	public ModelAndView eventClickMenuClientes(HttpSession httpSession, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		String viewName = ViewNameResolver.resolveViewName(
			(UserSessionDto)httpSession.getAttribute("userSession"),
			request.getServletPath()
		);
	    
	    mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="crearCliente.html")
	public ModelAndView eventClickCrearCliente(HttpSession httpSession, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		String viewName = ViewNameResolver.resolveViewName(
			(UserSessionDto)httpSession.getAttribute("userSession"),
			request.getServletPath()
		);
	    
	    mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="modificarCliente.html")
	public ModelAndView eventClickModificarCliente(HttpSession httpSession, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		String viewName = ViewNameResolver.resolveViewName(
			(UserSessionDto)httpSession.getAttribute("userSession"),
			request.getServletPath()
		);
	    
	    mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="adminCuentas.html")
	public ModelAndView eventClickMenuCuentas(HttpSession httpSession, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		String viewName = ViewNameResolver.resolveViewName(
			(UserSessionDto)httpSession.getAttribute("userSession"),
			request.getServletPath()
		);
	    
	    mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="crearCuenta.html")
	public ModelAndView eventClickCrearCuenta(HttpSession httpSession, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		String viewName = ViewNameResolver.resolveViewName(
			(UserSessionDto)httpSession.getAttribute("userSession"),
			request.getServletPath()
		);
	    
	    mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="guardarCuenta")
	public ModelAndView eventClickGuardarNuevaCuenta() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("adminCuentas");
		
		return mv;
	}
	
	@RequestMapping(value="cancelarCreacionCuenta")
	public ModelAndView eventClickCancelarCreacionDeCuenta() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("adminCuentas");
		
		return mv;
	}
	
	@RequestMapping(value="modificarCuenta.html")
	public ModelAndView eventClickModificarCuenta(HttpSession httpSession, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		String viewName = ViewNameResolver.resolveViewName(
			(UserSessionDto)httpSession.getAttribute("userSession"),
			request.getServletPath()
		);
	    
	    mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="eliminarCuenta")
	public ModelAndView eventClickEliminarCuenta() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("modificarCuenta");
		
		return mv;
	}
	
	@RequestMapping(value="guardarModificacionesCuenta")
	public ModelAndView eventClickGuardarModificacionesCuenta() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("adminCuentas");
		
		return mv;
	}
	
	@RequestMapping(value="cancelarModificacionCuenta")
	public ModelAndView eventClickCancelarModificacionDeCuenta() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("adminCuentas");
		
		return mv;
	}
	
}
