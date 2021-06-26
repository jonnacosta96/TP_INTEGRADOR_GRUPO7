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

@Controller
public class CuentaController {
		
	@RequestMapping("/buscarCliente.html")
    @ResponseBody
    public String buscarCliente(@RequestParam Integer dni, Model model)
	{    	    
		ClienteNegImpl clienteNegImpl = new ClienteNegImpl();
	    CuentaNegImpl cuentaNegImpl = new CuentaNegImpl();
	    
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
	    
	    ClienteNegImpl clienteNegImpl = new ClienteNegImpl();
	    CuentaNegImpl cuentaNegImpl = new CuentaNegImpl();
	    TipoCuentaNegImpl tipoCuentaNegImpl = new TipoCuentaNegImpl();
	    ParametroNegImpl parametroNegImpl = new ParametroNegImpl();
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
    	
    	Cuenta cuenta = new Cuenta(
			cliente,
			crearCuentaDto.getCuentaNombre(),
			tipoCuenta,
			cbu,
			Calendar.getInstance().getTime(),
			10000,
			true
		);
    	
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
    
}
