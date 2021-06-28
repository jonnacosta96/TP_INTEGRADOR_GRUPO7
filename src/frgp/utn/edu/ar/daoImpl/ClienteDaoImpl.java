package frgp.utn.edu.ar.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.dao.ClienteDao;
import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Usuario;

public class ClienteDaoImpl implements ClienteDao {
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");

	@Override
	public List<Cliente> ObtenerListadoClientes(boolean estado) {
		
		try {
			Conexion cn = (Conexion)appContext.getBean("conexion");
			Session session = cn.abrirConexion();
			
			String query = "FROM Cliente cli WHERE cli.estadoCliente = 1";
			List<Cliente> lista = (List<Cliente>)session.createQuery(query).list();
			cn.cerrarSession();
			
			return lista;
		}
		catch (Exception ex)
		{
			return null;
		}

	}

	@Override
	public boolean GuardarCliente(Cliente cli) {
		
		try {
			Conexion cn = (Conexion)appContext.getBean("conexion");
			Session session = cn.abrirConexion();
			
			session.beginTransaction();
			
			session.saveOrUpdate(cli);
			
			session.getTransaction().commit();
			
			cn.cerrarSession();
		}
		catch(Exception ex) {
			return false;
		}

		
		return true;
	}

	@Override
	public Cliente ObtenerClientexNroCliente(int nroCliente) {
		
		try {
			Conexion cn = (Conexion)appContext.getBean("conexion");
			Session session = cn.abrirConexion();
			
			session.beginTransaction();
			
			String query = "FROM Cliente cli WHERE cli.nroCliente = :nrocliente";
		
			Cliente cli = (Cliente) session.createQuery(query).setParameter("nrocliente", nroCliente).uniqueResult();
			
			session.getTransaction().commit();
			
			cn.cerrarSession();
			
			return cli;
		}
		catch(Exception ex) {
			return null;
		}
	}

	@Override
	public Cliente ObtenerClientexDNI(int dni) {
		
		try {
			Conexion cn = (Conexion)appContext.getBean("conexion");
			Session session = cn.abrirConexion();
			
			session.beginTransaction();
			
			String query = "FROM Cliente cli WHERE cli.dni = :dni and cli.estadoCliente=1";
		
			Cliente cli = (Cliente) session.createQuery(query).setParameter("dni", dni).uniqueResult();
			
			session.getTransaction().commit();
			
			cn.cerrarSession();
			
			return cli;
		}
		catch(Exception ex) {
			return null;
		}
		
	}

	@Override
	public Cliente ObtenerClientexUsuario(Usuario usuario) {
		
		Cliente cli = new Cliente();
		
		try {
			Conexion cn = (Conexion)appContext.getBean("conexion");
			Session session = cn.abrirConexion();
			
			session.beginTransaction();
			
			String query = "FROM Cliente cli WHERE cli.usuario= :user";
		
			cli = (Cliente) session.createQuery(query).setParameter("user", usuario).uniqueResult();
			
			session.getTransaction().commit();
			
			cn.cerrarSession();
		}
		catch(Exception ex) {
			return null;
		}
		
		return cli;
	}


}
