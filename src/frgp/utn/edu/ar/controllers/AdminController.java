package frgp.utn.edu.ar.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
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
			@ModelAttribute("msgAlta") final String msgAlta
	) {
		
		ModelAndView mav = new ModelAndView();
		String viewName = ViewNameResolver.resolveViewName(
			(UserSessionDto)httpSession.getAttribute("userSession"),
			request.getServletPath()
		);
		
		CuentaNegImpl cuentaNegImpl = new CuentaNegImpl();
		
		List<Cuenta> lista = cuentaNegImpl.ObtenerListadoCuentas(true);
		
		mav.addObject("ListaCuentas", lista);
		mav.addObject("msgAlta", msgAlta);
	    
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
		TipoCuentaNegImpl tipoCuentaNegImpl = new TipoCuentaNegImpl();
		
		if(!viewName.contains("login")) {
					
			List<TipoCuenta> tiposCuenta = tipoCuentaNegImpl.ObtenerListadoTiposCuenta(true);
			mav.addObject("tiposCuenta", tiposCuenta);
			
		}
	    
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
