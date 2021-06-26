package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.entidades.TipoCuenta;
import frgp.utn.edu.ar.negocio.TipoCuentaNeg;
import frgp.utn.edu.ar.daoImpl.TipoCuentaDaoImpl;
import frgp.utn.edu.ar.daoImpl.UserDaoImpl;

public class TipoCuentaNegImpl implements TipoCuentaNeg {
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	TipoCuentaDaoImpl tipoCuentaDaoImpl = (TipoCuentaDaoImpl)appContext.getBean("tipoCuentaDaoImpl");

	@Override
	public List<TipoCuenta> ObtenerListadoTiposCuenta(boolean estado) {
		List<TipoCuenta> lista = tipoCuentaDaoImpl.ObtenerListadoTiposCuenta(estado);
		return lista;
	}

	@Override
	public TipoCuenta ObtenerTipoCuenta(String codigo) {
		TipoCuenta tipoCuenta = tipoCuentaDaoImpl.ObtenerTipoCuenta(codigo);
		return tipoCuenta;
	}

}
