package frgp.utn.edu.ar.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.dto.UserSessionDto;
import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Cuenta;
import frgp.utn.edu.ar.entidades.TipoCuenta;
import frgp.utn.edu.ar.negocioImpl.ClienteNegImpl;
import frgp.utn.edu.ar.negocioImpl.CuentaNegImpl;
import frgp.utn.edu.ar.negocioImpl.LocalidadNegImpl;
import frgp.utn.edu.ar.negocioImpl.PaisNegImpl;
import frgp.utn.edu.ar.negocioImpl.ProvinciaNegImpl;
import frgp.utn.edu.ar.negocioImpl.TipoCuentaNegImpl;
import helpers.ViewNameResolver;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


@Controller
public class AdminController {
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");

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
	
	@RequestMapping(value="adminCuentas.html")
	public ModelAndView eventClickMenuCuentas(
			HttpSession httpSession,
			HttpServletRequest request,
			@ModelAttribute("msgAlta") final String msgAlta,
			@ModelAttribute("msgModificacion") final String msgModificacion
	) {
		
		ModelAndView mav = new ModelAndView();
		String viewName = ViewNameResolver.resolveViewName(
			(UserSessionDto)httpSession.getAttribute("userSession"),
			request.getServletPath()
		);
		
		CuentaNegImpl cuentaNegImpl = (CuentaNegImpl)appContext.getBean("cuentaNegImpl");
		
		List<Cuenta> lista = cuentaNegImpl.ObtenerListadoCuentas(true);
		
		mav.addObject("ListaCuentas", lista);
		mav.addObject("msgAlta", msgAlta);
		mav.addObject("msgModificacion", msgModificacion);
	    
	    mav.setViewName(viewName);
		return mav;
	}
	
}
