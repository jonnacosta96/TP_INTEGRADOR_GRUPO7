package frgp.utn.edu.ar.controllers;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.dto.CrearCuentaDto;
import frgp.utn.edu.ar.dto.EditarCuentaDto;
import frgp.utn.edu.ar.dto.UserSessionDto;
import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Cuenta;
import frgp.utn.edu.ar.entidades.Login;
import frgp.utn.edu.ar.entidades.Parametro;
import frgp.utn.edu.ar.entidades.TipoCuenta;
import frgp.utn.edu.ar.entidades.Usuario;
import frgp.utn.edu.ar.negocioImpl.ClienteNegImpl;
import frgp.utn.edu.ar.negocioImpl.CuentaNegImpl;
import frgp.utn.edu.ar.negocioImpl.ParametroNegImpl;
import frgp.utn.edu.ar.negocioImpl.TipoCuentaNegImpl;
import helpers.JSONResponseFormatter;
import helpers.ViewNameResolver;

@Controller
public class CuentaController {
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	
	@RequestMapping("/buscarCliente.html")
    @ResponseBody
    public String buscarCliente(@RequestParam Integer dni, Model model)
	{    	    
		ClienteNegImpl clienteNegImpl = (ClienteNegImpl)appContext.getBean("clienteNegImpl");
	    CuentaNegImpl cuentaNegImpl = (CuentaNegImpl)appContext.getBean("cuentaNegImpl");
	    
	    Cliente cliente = clienteNegImpl.ObtenerClientexDNI(dni);
	    
	    if(cliente != null)
	    {
	    	Long cantidadCuentas = cuentaNegImpl.CantidadCuentasxNroCliente(cliente);
	    	
	    	String nombreCliente = ((Integer)cliente.getNroCliente()).toString() + " - " + cliente.getNombre().toString() + " " + cliente.getApellido().toString();
	    	
	    	String returnValue = "{";
	    	returnValue = JSONResponseFormatter.addObject(returnValue, "nombre", nombreCliente,true);
	    	returnValue = JSONResponseFormatter.addObject(returnValue, "id", ((Integer)cliente.getNroCliente()).toString(),true);
	    	if(cantidadCuentas >= 4)
	    	{
	    		returnValue = JSONResponseFormatter.addObject(returnValue, "result", "error",true);
	    		returnValue = JSONResponseFormatter.addObject(returnValue, "error", "El cliente tiene 4 o mas cuentas asignadas",false);
	    	}
	    	else
	    	{
	    		returnValue = JSONResponseFormatter.addObject(returnValue, "result", "ok",false);
	    	}
	    		
	    	returnValue = returnValue + "}";
	    	
	    	return returnValue;
	    }
	    else
	    {
	    	String returnValue = "{";
	    	returnValue = JSONResponseFormatter.addObject(returnValue, "result", "error",true);
	    	returnValue = JSONResponseFormatter.addObject(returnValue, "error", "Cliente no encontrado o no activo",false);
	    	returnValue = returnValue + "}";
	    	
	    	return returnValue;
	    }
	    
	    
    }
     
	@RequestMapping (value = "guardarNuevaCuenta.html", method = RequestMethod.POST)
	@ResponseBody
	  public ModelAndView crearCuenta(
		  HttpServletRequest request,
		  HttpServletResponse response,
		  @ModelAttribute("cuentaCrear") CrearCuentaDto crearCuentaDto,
		  HttpSession httpSession,
		  ModelAndView modelAndView,
		  Model model
	  ) {
	    
		ClienteNegImpl clienteNegImpl = (ClienteNegImpl)appContext.getBean("clienteNegImpl");
		CuentaNegImpl cuentaNegImpl = (CuentaNegImpl)appContext.getBean("cuentaNegImpl");
	    TipoCuentaNegImpl tipoCuentaNegImpl = (TipoCuentaNegImpl)appContext.getBean("tipoCuentaNegImpl");
	    ParametroNegImpl parametroNegImpl = (ParametroNegImpl)appContext.getBean("parametroNegImpl");
	    Boolean flag = true; 
	    
	    List<TipoCuenta> tiposCuenta = tipoCuentaNegImpl.ObtenerListadoTiposCuenta(true);
	    
	    if(crearCuentaDto.getTipoCuenta().equals("")) flag = false;
	    if(crearCuentaDto.getClienteId() == null) flag = false;
	    if(crearCuentaDto.getClienteId() != null && crearCuentaDto.getClienteId().equals("")) flag = false;
	    if(crearCuentaDto.getCuentaNombre().equals("")) flag = false;
	    
	    modelAndView.setViewName("crearCuenta");
    	modelAndView.addObject("parameters", crearCuentaDto);
	    
	    if(!flag)
	    {
	    	modelAndView.addObject("error", "Por favor, complete todos los campos");
	    	modelAndView.addObject("tiposCuenta", tiposCuenta);
	    	return modelAndView;
	    }
	    
	    Cliente cliente = clienteNegImpl.ObtenerClientexNroCliente(crearCuentaDto.getClienteId());
	    
	    if(cliente == null)
	    {
	    	modelAndView.addObject("error", "Cliente no existe");
	    	modelAndView.addObject("tiposCuenta", tiposCuenta);
	    	return modelAndView;
	    }
	    
	    if(crearCuentaDto.getCuentaNombre().length() > 50)
	    {
	    	modelAndView.addObject("errorNombreCuenta", "Ingrese un nombre de menos de 50 caracteres.");
	    	modelAndView.addObject("tiposCuenta", tiposCuenta);
	    	return modelAndView;
	    }
	    
	    Long cantidadCuentas = cuentaNegImpl.CantidadCuentasxNroCliente(cliente);
    	
    	if(cantidadCuentas >= 4)
    	{
	    	modelAndView.addObject("error", "El cliente tiene 4 o mas cuentas creadas");
	    	modelAndView.addObject("tiposCuenta", tiposCuenta);
	    	return modelAndView;
    	}
	    
    	TipoCuenta tipoCuenta = tipoCuentaNegImpl.ObtenerTipoCuenta(crearCuentaDto.getTipoCuenta());
    	
    	if(tipoCuenta == null)
    	{
	    	modelAndView.addObject("error", "Tipo de cuenta inexistente");
	    	modelAndView.addObject("tiposCuenta", tiposCuenta);
	    	return modelAndView;
    	}
    	
    	Parametro parametro = parametroNegImpl.ObtenerParametroxCodigo("LAST_CBU");
    	Integer cbu = parametro.getIntegerParamValue() + 1;
    	parametro.setIntegerParamValue(cbu);
    	
    	Cuenta cuenta = (Cuenta)appContext.getBean("cuenta");
    	
    	cuenta.setCliente(cliente);
    	cuenta.setNombre(crearCuentaDto.getCuentaNombre());
    	cuenta.setTipoCuenta(tipoCuenta);
    	
    	Boolean resultado = cuentaNegImpl.GuardarCuenta(cuenta);
    	
    	if(resultado)
    	{
    		model.addAttribute("msgAlta", cuenta.getNroCuenta());
    		modelAndView.setViewName("redirect:/adminCuentas.html");
    	}
    	else
    	{
    		modelAndView.setViewName("crearCuenta");
	    	modelAndView.addObject("parameters", crearCuentaDto);
	    	modelAndView.addObject("error", "Error al crear la cuenta");
	    	modelAndView.addObject("tiposCuenta", tiposCuenta);
	    	return modelAndView;
    	}
	    
		return modelAndView;
	}
	
	@RequestMapping(value="crearCuenta.html")
	public ModelAndView eventClickCrearCuenta(HttpSession httpSession, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		String viewName = ViewNameResolver.resolveViewName(
			(UserSessionDto)httpSession.getAttribute("userSession"),
			request.getServletPath()
		);
		
		mav.setViewName(viewName);
	    TipoCuentaNegImpl tipoCuentaNegImpl = (TipoCuentaNegImpl)appContext.getBean("tipoCuentaNegImpl");
		
		if(!viewName.contains("login")) {
					
			List<TipoCuenta> tiposCuenta = tipoCuentaNegImpl.ObtenerListadoTiposCuenta(true);
			mav.addObject("tiposCuenta", tiposCuenta);
			
		}
	    
		return mav;
	}
	
	@RequestMapping(value="editarCuenta.html")
	public ModelAndView editarCuenta(
		HttpSession httpSession,
		HttpServletRequest request,
		@ModelAttribute("cuentaEditar") EditarCuentaDto editarCuentaDto,
		Model model
	) {
		
		CuentaNegImpl cuentaNegImpl = (CuentaNegImpl)appContext.getBean("cuentaNegImpl");
		Boolean flag = true;
		ModelAndView mav = new ModelAndView();
		
		Cuenta cuenta = cuentaNegImpl.ObtenerCuentaxNroCuenta(editarCuentaDto.getNroCuenta());
		
		mav.setViewName("modificarCuenta");
		
		if(editarCuentaDto.getNroCuenta() == null || editarCuentaDto.getNroCuenta().equals("")) flag = false;
		if(editarCuentaDto.getNombreCuenta() == null || editarCuentaDto.getNombreCuenta().equals("")) flag = false;
		
		if(!flag)
	    {
			mav.addObject("nroCuenta", editarCuentaDto.getNroCuenta());
			mav.addObject("nombreCuenta", editarCuentaDto.getNombreCuenta());
			mav.addObject("nombreCliente", editarCuentaDto.getNombreCliente());
			mav.addObject("tipoCuenta", editarCuentaDto.getTipoCuenta());
			mav.addObject("errorNombreCuenta", "Por favor, ingrese un nombre");
	    	return mav;
	    }
		
		if(editarCuentaDto.getNombreCuenta().length() > 50)
	    {
			mav.addObject("nroCuenta", editarCuentaDto.getNroCuenta());
			mav.addObject("nombreCuenta", editarCuentaDto.getNombreCuenta());
			mav.addObject("nombreCliente", editarCuentaDto.getNombreCliente());
			mav.addObject("tipoCuenta", editarCuentaDto.getTipoCuenta());
			mav.addObject("errorNombreCuenta", "Ingrese un nombre de menos de 50 caracteres.");
	    	return mav;
	    }
		
		cuenta.setNombre(editarCuentaDto.getNombreCuenta());
		
		Boolean resultado = cuentaNegImpl.GuardarCuenta(cuenta);
		
		if(resultado)
    	{
    		model.addAttribute("msgModificacion", cuenta.getNroCuenta());
    		mav.setViewName("redirect:/adminCuentas.html");
    	}
    	else
    	{
    		mav.addObject("nroCuenta", editarCuentaDto.getNroCuenta());
			mav.addObject("nombreCuenta", editarCuentaDto.getNombreCuenta());
			mav.addObject("nombreCliente", editarCuentaDto.getNombreCliente());
			mav.addObject("tipoCuenta", editarCuentaDto.getTipoCuenta());
    		mav.addObject("error", "Error al modificar la cuenta");
	    	return mav;
    	}
	    
		return mav;
	}
	
	@RequestMapping("accionCuenta.html")
	public ModelAndView accionCuenta(int nroCuenta, String modificarCuenta)
	{
		ModelAndView mv = new ModelAndView();
		CuentaNegImpl cuentaNegImpl = (CuentaNegImpl)appContext.getBean("cuentaNegImpl");
		Cuenta cuenta = cuentaNegImpl.ObtenerCuentaxNroCuenta(nroCuenta);
		
		if(modificarCuenta != null)
		{
			mv.addObject("nroCuenta", cuenta.getNroCuenta());
			mv.addObject("nombreCuenta", cuenta.getNombre());
			mv.addObject("nombreCliente", cuenta.getCliente().getNombre() + " " + cuenta.getCliente().getApellido());
			mv.addObject("tipoCuenta", cuenta.getTipoCuenta().getNombre());
			mv.setViewName("modificarCuenta");
		}
		else
		{
			cuenta.setActivo(false);
			Boolean resultado = cuentaNegImpl.GuardarCuenta(cuenta);
			
			if(resultado) {
				mv.addObject("eliminacionExitosa", "correcto");
			}
			else {
				mv.addObject("eliminacionFallida", "fallo");
			}
			
			List<Cuenta> cuentas = cuentaNegImpl.ObtenerListadoCuentas(true);
			
			mv.addObject("ListaCuentas", cuentas);
			mv.setViewName("adminCuentas");
				
		}
		
		return mv;
	}
    
}
