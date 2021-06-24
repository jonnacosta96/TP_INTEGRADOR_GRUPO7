package frgp.utn.edu.ar.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
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
import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Cuenta;
import frgp.utn.edu.ar.entidades.Login;
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
	    
	    String hql = "FROM Cliente c WHERE c.dni = :dni";
	    
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
	    	returnValue = JSONResponseFormatter.addObject(returnValue, "error", "Cliente no encontrado",false);
	    	returnValue = returnValue + "}";
	    	
	    	return returnValue;
	    }
	    
	    
    }
     
	@RequestMapping(value = "crearCuenta.html", method = RequestMethod.POST)
	  public ModelAndView crearCuenta(
			  HttpServletRequest request,
			  HttpServletResponse response,
			  @ModelAttribute("login") Login login,
			  HttpSession httpSession
			  ) {
		
		
		return new ModelAndView();
	}
    
}
