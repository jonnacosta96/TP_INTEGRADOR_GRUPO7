	package frgp.utn.edu.ar.controllers;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import frgp.utn.edu.ar.entidades.Usuario;
import frgp.utn.edu.ar.entidades.Login;
import helpers.FillDatabase;
import helpers.ViewNameResolver;
import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.dto.UserSessionDto;

@Controller
public class LogInController {

  @RequestMapping("login.html")
  public ModelAndView eventLoadPage(Model model, HttpSession httpSession, HttpServletRequest request) {
    
	model.addAttribute("login", new Login());
	
    ModelAndView mav = new ModelAndView();
	String viewName = ViewNameResolver.resolveViewName(
		(UserSessionDto)httpSession.getAttribute("userSession"),
		request.getServletPath()
	);
	
	//FillDatabase.GenerateRecords();
    
    mav.setViewName(viewName);

    return mav;
  }

  @RequestMapping(value = "loginProcess.html", method = RequestMethod.POST)
  public ModelAndView loginProcess(
		  HttpServletRequest request,
		  HttpServletResponse response,
		  @ModelAttribute("login") Login login,
		  HttpSession httpSession
		  ) {
    ModelAndView mav = null;
    
    Conexion cn = new Conexion();
    Session session = cn.abrirConexion();
    
    String hql = "from Usuario u where u.username = :username and u.password = :password and u.activo = 1";
    Usuario user = (Usuario)session.createQuery(hql)
	    		.setParameter("username", login.getUsername())
	    		.setParameter("password", login.getPassword())
	    		.uniqueResult();
    
    cn.cerrarSession();

    if (null != user) {
    	mav = new ModelAndView();
    	
		if(user.getTipo().toString().toUpperCase().equals("ADMIN"))
		{
			mav.setViewName("redirect:/adminHome.html");
		}
		if(user.getTipo().toString().toUpperCase().equals("CUSTOMER"))
		{
			mav.setViewName("redirect:/clienteHome.html");
		}
		
		String userName = user.getNombre().toString() + " " + user.getApellido().toString();
		
		httpSession.setAttribute("userSession", new UserSessionDto(
			userName,
			LocalDateTime.now(),
			user.getTipo()
		));
		
    } else {
      mav = new ModelAndView();
      mav.setViewName("login");
      mav.addObject("message", "Error. Usuario y/o contraseña incorrectos.");
    }

    return mav;
  }
  
  @RequestMapping(value = "logout.html")
  public ModelAndView logout(HttpSession httpSession) {
    ModelAndView mav = new ModelAndView();
    
    httpSession.removeAttribute("userSession");
    mav.setViewName("redirect:/login.html");
    
    return mav;
  }
}