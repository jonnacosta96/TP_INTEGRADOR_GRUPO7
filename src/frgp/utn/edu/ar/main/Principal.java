package frgp.utn.edu.ar.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.entidades.Cuenta;

public class Principal {
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	
	public static void main(String[] args) {
		
		Cuenta c1 = (Cuenta)appContext.getBean("cuenta");
		
		System.out.println("c1"+c1.toString());

		((ConfigurableApplicationContext)(appContext)).close();

	}

}
