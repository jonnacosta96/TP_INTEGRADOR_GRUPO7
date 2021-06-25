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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.dto.CrearCuentaDto;
import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Cuenta;
import frgp.utn.edu.ar.entidades.Login;
import frgp.utn.edu.ar.entidades.Parametro;
import frgp.utn.edu.ar.entidades.TipoCuenta;
import frgp.utn.edu.ar.entidades.Usuario;
import helpers.JSONResponseFormatter;

@Controller
public class CuentaController {
		
	@RequestMapping("/buscarCliente.html")
    @ResponseBody
    public String buscarCliente(@RequestParam Integer dni, Model model)
	{    
		Conexion cn = new Conexion();
	    Session session = cn.abrirConexion();
	    
	    String hql = "FROM Cliente c WHERE c.dni = :dni and c.estadoCliente = 1";
	    
	    Cliente cliente = (Cliente)session.createQuery(hql)
	    		.setParameter("dni", dni)
	    		.uniqueResult();
	    
	    if(cliente != null)
	    {
	    	hql = "SELECT COUNT(c) FROM Cuenta c WHERE c.cliente = :cliente";
	    	Long cantidadCuentas = (Long)session.createQuery(hql)
	    			.setParameter("cliente", cliente)
	    			.uniqueResult();
	    	String nombreCliente = ((Integer)cliente.getNroCliente()).toString() + " - " + cliente.getNombre().toString() + " " + cliente.getApellido().toString();
	    	
	    	cn.cerrarSession();
	    	
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
			  ModelAndView modelAndView
			  ) {
		
		Conexion cn = new Conexion();
	    Session session = cn.abrirConexion();
	    
	    String hql = "FROM Cliente c WHERE c.nroCliente = :nroCliente and c.estadoCliente = 1";
	    
	    Cliente cliente = (Cliente)session.createQuery(hql)
	    		.setParameter("nroCliente", crearCuentaDto.getClienteId())
	    		.uniqueResult();
	    
	    hql = "from TipoCuenta";
	    List<TipoCuenta> tiposCuenta = (List<TipoCuenta>)session.createQuery(hql).list();
	    JSONArray array = new JSONArray();
	    
	    for(TipoCuenta tipo: tiposCuenta)
	    {
	    	JSONObject obj = new JSONObject();
	    	obj.put("code",tipo.getCodigo());
	    	obj.put("nombre",tipo.getNombre());
	    	array.add(obj);
	    }
	    
	    
	    
	    if(
	    	crearCuentaDto.getTipoCuenta().equals("") ||
	    	crearCuentaDto.getClienteId() == null ||
	    	crearCuentaDto.getClienteId().equals("") ||
	    	crearCuentaDto.getCuentaNombre().equals("")
		)
	    {
	    	modelAndView.setViewName("crearCuenta");
	    	modelAndView.addObject("parameters", crearCuentaDto);
	    	modelAndView.addObject("etiquetaCliente", crearCuentaDto.getClienteNombre());
	    	modelAndView.addObject("nombreCuenta", crearCuentaDto.getCuentaNombre());
	    	modelAndView.addObject("idCliente", crearCuentaDto.getClienteId());
	    	modelAndView.addObject("idTipoCuenta", crearCuentaDto.getTipoCuenta());
	    	modelAndView.addObject("error", "Por favor, complete todos los campos");
	    	request.setAttribute("tiposCuenta", array);
	    	return modelAndView;
	    }
	    
	    if(cliente == null)
	    {
	    	modelAndView.setViewName("crearCuenta");
	    	modelAndView.addObject("parameters", crearCuentaDto);
	    	modelAndView.addObject("error", "Cliente no existe");
	    	return modelAndView;
	    }
	    
	    hql = "SELECT COUNT(c) FROM Cuenta c WHERE c.cliente = :cliente";
    	Long cantidadCuentas = (Long)session.createQuery(hql)
    			.setParameter("cliente", cliente)
    			.uniqueResult();
    	
    	if(cantidadCuentas >= 4)
    	{
    		modelAndView.setViewName("crearCuenta");
	    	modelAndView.addObject("parameters", crearCuentaDto);
	    	modelAndView.addObject("error", "El cliente tiene 4 o mas cuentas creadas");
	    	return modelAndView;
    	}
	    
    	hql = "FROM TipoCuenta tc WHERE tc.codigo = :codigo";
    	TipoCuenta tipoCuenta = (TipoCuenta)session.createQuery(hql)
	    		.setParameter("codigo", crearCuentaDto.getTipoCuenta())
	    		.uniqueResult();
    	
    	if(tipoCuenta == null)
    	{
    		modelAndView.setViewName("crearCuenta");
	    	modelAndView.addObject("parameters", crearCuentaDto);
	    	modelAndView.addObject("error", "Tipo de cuenta inexistente");
	    	return modelAndView;
    	}
    	
    	hql = "FROM Parametro pm WHERE pm.id = 'LAST_CBU'";
    	Parametro parametro = (Parametro)session.createQuery(hql)
    			.uniqueResult();
    	
    	Cuenta cuenta = new Cuenta(
			cliente,
			crearCuentaDto.getCuentaNombre(),
			tipoCuenta,
			parametro.getIntegerParamValue(),
			Calendar.getInstance().getTime(),
			10000,
			true
		);
    	
    	try {
    		session.beginTransaction();
        	session.saveOrUpdate(cuenta);
        	session.getTransaction().commit();
    	}
    	catch(Exception e) {
    		modelAndView.setViewName("crearCuenta");
	    	modelAndView.addObject("parameters", crearCuentaDto);
	    	modelAndView.addObject("error", "Error al crear la cuenta");
	    	return modelAndView;
    	}
		
	    modelAndView.setViewName("redirect:/adminCuentas.html");
		return modelAndView;
	}
    
}
