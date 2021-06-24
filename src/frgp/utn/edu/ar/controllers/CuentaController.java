package frgp.utn.edu.ar.controllers;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Usuario;

@Controller
public class CuentaController {
	
	@RequestMapping("/buscarCliente2.html")
    @ResponseBody
    public String buscarCliente2(@RequestParam Integer dni, Model model)
	{
    	Conexion cn = new Conexion();
	    Session session = cn.abrirConexion();
	    
	    String hql = "FROM Cliente c WHERE c.dni = :dni";
	    
	    Cliente cliente = (Cliente)session.createQuery(hql)
	    		.setParameter("dni", dni)
	    		.uniqueResult();
	    
	    cn.cerrarSession();
	    
    	return cliente.getNombre() + " " + cliente.getApellido();
    }
	
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
	    
	    cn.cerrarSession();
	    
	    if(cliente != null)
	    {
	    	String nombreCliente = cliente.getNombre().toString() + " " + cliente.getApellido().toString();
	    	return "{\"nombre\":\"" + nombreCliente + "\"}";
	    }
	    else
	    {
	    	return "{\"error\":\"Cliente no encontrado\"}";
	    }
	    
	    
    }
     
    @RequestMapping("/loginDisponible.html")
    @ResponseBody
    public String loginDisponible(@RequestParam Integer id, Model model)
	{    
    	model.addAttribute("prueba", false);
    	return "crearCuenta.html";
    }
    
    
 
	@RequestMapping("cuentaCrearBuscarCliente.html")
	public ModelAndView LoadListClients(Integer dni) {
		
		ModelAndView mv = new ModelAndView();
		
		Conexion cn = new Conexion();
	    Session session = cn.abrirConexion();
	    
	    String hql = "FROM Cliente c WHERE c.dni = :dni";
	    
	    Cliente cliente = (Cliente)session.createQuery(hql)
	    		.setParameter("dni", dni)
	    		.uniqueResult();
	    
	    cn.cerrarSession();
	    
	    mv.addObject("estadoAgregarPersona", cliente);
	    mv.setViewName("crearCuenta");
		
		return mv;
	}
}
