package frgp.utn.edu.ar.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.dto.UserSessionDto;
import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Cuenta;
import frgp.utn.edu.ar.entidades.Transaccion;
import frgp.utn.edu.ar.entidades.Usuario;
import frgp.utn.edu.ar.negocioImpl.ClienteNegImpl;
import frgp.utn.edu.ar.negocioImpl.CuentaNegImpl;
import frgp.utn.edu.ar.negocioImpl.TransaccionNegImpl;
import helpers.ViewNameResolver;

@Controller
public class HomeClienteController {
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	
	@RequestMapping("clienteHome.html")
	public ModelAndView eventLoadPage(HttpSession httpSession, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		String viewName = ViewNameResolver.resolveViewName(
			(UserSessionDto)httpSession.getAttribute("userSession"),
			request.getServletPath()
		);
	    
		ClienteNegImpl cliNegImpl = (ClienteNegImpl)appContext.getBean("clienteNegImpl");
		CuentaNegImpl cuentaNegImpl = (CuentaNegImpl)appContext.getBean("cuentaNegImpl");
		TransaccionNegImpl transacNegImpl = (TransaccionNegImpl)appContext.getBean("transaccionNegImpl");
		
		Usuario user = (Usuario)httpSession.getAttribute("userLogeado");
		Cliente cli = cliNegImpl.ObtenerClientexUsuario(user);
		List<Cuenta> lista = cuentaNegImpl.ObtenerListadoCuentasxCliente(cli);
		List<Transaccion> listaTransacciones = transacNegImpl.ObtenerListadoTransaccionesxCliente(cli);

		mav.addObject("Cliente", cli);
		mav.addObject("listaCuentasCliente",lista);
		mav.addObject("ListaTransaccionesCliente", listaTransacciones);
	    mav.setViewName(viewName);
	    
		return mav;
	}
		
	@RequestMapping(value = { "/transferir.html" }, method = RequestMethod.GET)
	public ModelAndView transferir(HttpSession httpSession, HttpServletRequest request,@RequestParam("nroCliente") int nroCliente) {
		
		ModelAndView mav = new ModelAndView();
		String viewName = ViewNameResolver.resolveViewName(
			(UserSessionDto)httpSession.getAttribute("userSession"),
			request.getServletPath()
		);
		
		ClienteNegImpl cliNegImpl = (ClienteNegImpl)appContext.getBean("clienteNegImpl");
		CuentaNegImpl cuentaNegImpl = (CuentaNegImpl)appContext.getBean("cuentaNegImpl");
		
		Cliente cli = cliNegImpl.ObtenerClientexNroCliente(nroCliente);
	    List<Cuenta> lista = cuentaNegImpl.ObtenerListadoCuentasxCliente(cli);
	    
	    mav.addObject("ListaCuentasCliente", lista);
	    mav.addObject("Cliente",cli);
	    
	    mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value = { "/TransaccionesxCuenta.html" }, method = RequestMethod.GET)
	public ModelAndView listaTransaccioenesCuenta(HttpSession httpSession, HttpServletRequest request,@RequestParam("nroCuenta") int nroCuenta) {
		
		ModelAndView mav = new ModelAndView();
		String viewName = ViewNameResolver.resolveViewName(
			(UserSessionDto)httpSession.getAttribute("userSession"),
			request.getServletPath()
		);
		
		CuentaNegImpl cuentaNegImpl = (CuentaNegImpl)appContext.getBean("cuentaNegImpl");
		TransaccionNegImpl transacNegImpl = (TransaccionNegImpl)appContext.getBean("transaccionNegImpl");
		
		Cuenta cuenta = cuentaNegImpl.ObtenerCuentaxNroCuenta(nroCuenta);
		List<Transaccion> lista = transacNegImpl.ObtenerListadoTransaccionesxCuenta(cuenta);
	    
	    mav.addObject("ListaTransaccionesCuenta", lista);
	    
	    mav.setViewName("TransaccionesxCuenta");
		return mav;
	}
	
}
