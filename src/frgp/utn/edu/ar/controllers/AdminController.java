package frgp.utn.edu.ar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AdminController {

	@RequestMapping(value="adminHome.html")
	public ModelAndView eventClickAdminHome() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("adminHome");
		
		return mv;
	}
	
	@RequestMapping(value="adminClientes.html")
	public ModelAndView eventClickMenuClientes() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("adminClientes");
		
		return mv;
	}
	
	@RequestMapping(value="crearCliente.html")
	public ModelAndView eventClickCrearCliente() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("crearCliente");
		
		return mv;
	}
	
	@RequestMapping(value="modificarCliente.html")
	public ModelAndView eventClickModificarCliente() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("modificarCliente");
		
		return mv;
	}
	// Cuentas
	
	@RequestMapping(value="adminCuentas.html")
	public ModelAndView eventClickMenuCuentas() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("adminCuentas");
		
		return mv;
	}
	
	@RequestMapping(value="crearCuenta.html")
	public ModelAndView eventClickCrearCuenta() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("crearCuenta");
		
		return mv;
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
	public ModelAndView eventClickModificarCuenta() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("modificarCuenta");
		
		return mv;
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
