package frgp.utn.edu.ar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

  @RequestMapping("index.html")
  public ModelAndView eventLoadPage() {

    ModelAndView mv = new ModelAndView();
    mv.setViewName("index");

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

  @RequestMapping(value = "loginProcess", method = RequestMethod.POST)
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") Login login) {
    ModelAndView mav = null;
    User user = userService.validateUser(login);
    if (null != user) {
      mav = new ModelAndView("welcome");
      mav.addObject("firstname", user.getFirstname());
    } else {
      mav = new ModelAndView("login");
      mav.addObject("message", "Username or Password is wrong!!");
    }
    return mav;
  }

}