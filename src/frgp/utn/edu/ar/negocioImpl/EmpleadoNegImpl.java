package frgp.utn.edu.ar.negocioImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.daoImpl.EmpleadoDaoImpl;
import frgp.utn.edu.ar.entidades.Empleado;
import frgp.utn.edu.ar.entidades.Usuario;
import frgp.utn.edu.ar.negocio.EmpleadoNeg;

public class EmpleadoNegImpl implements EmpleadoNeg {
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	private EmpleadoDaoImpl empleadoDaoImpl;
	
	@Override
	public Empleado ObtenerEmpleadoXUserId(Usuario usuario) {
		if(empleadoDaoImpl == null)
			empleadoDaoImpl = (EmpleadoDaoImpl)appContext.getBean("empleadoDaoImpl");
		
		return empleadoDaoImpl.ObtenerEmpleadoXUserId(usuario);
	}

}
