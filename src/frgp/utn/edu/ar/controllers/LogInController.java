package frgp.utn.edu.ar.controllers;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import frgp.utn.edu.ar.entidades.User;
import frgp.utn.edu.ar.entidades.Login;
import frgp.utn.edu.ar.services.UserServiceImpl;

import frgp.utn.edu.ar.dao.Conexion;

@Controller
public class LogInController {

  UserServiceImpl userService;

  @RequestMapping("login.html")
  public ModelAndView eventLoadPage(Model model) {
    model.addAttribute("login", new Login());
    ModelAndView mv = new ModelAndView();
    mv.setViewName("login");

    Conexion cn = new Conexion();
    Session session = cn.abrirConexion();
    session.beginTransaction();

    User user = new User(
      "admin",
      "admin",
      "Admin",
      "User",
      "adim@user.com",
      "Alvear 575",
      1169203645,
      "Admin"
    );
    
    session.saveOrUpdate(user);
    
    User user2 = new User(
      "customer",
      "customer",
      "Customer",
      "User",
      "customer@user.com",
      "Alvear 575",
      1169203645,
      "Customer"
    );

    session.saveOrUpdate(user2);

    session.getTransaction().commit();
    session.close();

    return mv;
  }

  @RequestMapping(value = "validarIngreso.html", method = RequestMethod.POST)
  public ModelAndView eventLogInPage(String txtUsuario) {

    ModelAndView mv = new ModelAndView();
    Conexion cn = new Conexion();
    cn.abrirConexion();
    cn.cerrarSession();

    if (txtUsuario.toUpperCase().equals("CLIENTE")) {
      mv.setViewName("clienteHome");
    } else {
      mv.setViewName("adminHome");
    }

    return mv;
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

    User user = (User) session.createQuery("" +
      "SELECT u FROM " +
      "User u " +
      "WHERE u.username='" + login.getUsername() +
      "'	AND u.password='" + login.getPassword() + "'").uniqueResult();

    cn.cerrarSession();

    if (null != user) {
    	
    	String userName = "";
    	
		if(user.getType().toString().toUpperCase().equals("ADMIN"))
		{
			mav = new ModelAndView("adminHome");
			
		}
		if(user.getType().toString().toUpperCase().equals("CUSTOMER"))
		{
			mav = new ModelAndView("clienteHome");
		}
		
		userName = user.getFirstname().toString() + user.getLastname().toString();
		
		httpSession.setAttribute("userName", userName);
		
    } else {
      mav = new ModelAndView("login");
      mav.addObject("message", "Username or Password is wrong!!");
    }

    return mav;
  }

}