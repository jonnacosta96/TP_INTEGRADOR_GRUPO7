package frgp.utn.edu.ar.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.dto.UserSessionDto;
import frgp.utn.edu.ar.entidades.TipoCuenta;
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
	
	@RequestMapping(value="buscarCliente")
	public ModelAndView eventBuscarClienteEnCreacionCuenta(
			@RequestBody JSONObject usuario,
			HttpSession httpSession,
			HttpServletRequest request
		
	) {
		
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
		
		if(!viewName.contains("login")) {
					
			Conexion cn = new Conexion();
		    Session session = cn.abrirConexion();
		    
		    String hql = "from TipoCuenta";
		    List<TipoCuenta> tiposCuenta = (List<TipoCuenta>)session.createQuery(hql).list();
		    JSONArray array = new JSONArray();
		    
		    for(TipoCuenta tipo: tiposCuenta)
		    {
		    	JSONObject obj = new JSONObject();
		    	obj.put("code",tipo.getCodigo());
		    	obj.put("nombre",tipo.getNombre());
		    	array.add(obj);
		    }
		    
		    request.setAttribute("tiposCuenta", array);
		    
		    cn.cerrarSession();
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
