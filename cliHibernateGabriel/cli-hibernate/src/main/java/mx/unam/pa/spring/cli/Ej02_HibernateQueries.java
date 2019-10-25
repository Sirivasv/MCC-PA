package mx.unam.pa.spring.cli;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import mx.unam.pa.spring.cli.hibernate.model.Usuario;

/**
 * Consultas a la base de datos para obtener registros 
 * que cumplan con determinadas condiciones usando HQL.
 * 
 * Nota: Si la clase se revisa en un IDE, se mostrarán avertencias 
 * correspondientes a "The expression of type List needs unchecked conversion to conform to List<Usuario>" 
 * en las líneas 42 y 54 de esta clase.
 *
 * Clase: Programación Avanzada 2020-I
 * @author Gabriel González G.
 * @date Aug 17, 2019, 5:28:10 PM
 *
 */
public class Ej02_HibernateQueries extends Ej01_SimpleHibernate{
	public static void main(String[] args) {
		Ej02_HibernateQueries demo = new Ej02_HibernateQueries();
		try( SessionFactory factory = demo.initSessionFactory() ){
			
			//solicitud de un objeto de conxión
			Session session = factory.getCurrentSession();
			
			// Inicio de la transacción
			session.beginTransaction();
			
			/*
			 * Recuperando todos los usuarios de la tabla. 
			 * Equivalente a 
			 * SELECT * FROM usuario;
			 */
			System.out.println();
			System.out.println("Listado de todos los usuarios en la tabla");
			
			List<Usuario> usuarios = session.createQuery("from Usuario")
					.getResultList();
			
			demo.imprimirLista(usuarios);
			
			usuarios = session.createQuery("from Usuario", Usuario.class)
					.getResultList();
			
			demo.imprimirLista(usuarios);
			
			/* 
			 * Agregando criterios a la consulta
			 * Equivalente a 
			 * SELECT * FROM usuario WHERE apellido_paterno = 'González' 
			 */
			System.out.println();
			System.out.println("Listado de todos los usuarios cuyo apellido paterno sea González");
			usuarios = session.createQuery("from Usuario s where s.apPaterno='González'")
					.getResultList();
	
			demo.imprimirLista(usuarios);
			
			session.getTransaction().commit();
		}
	}
	
	public void imprimirLista(List<Usuario> listaUsuarios) {
		System.out.println();
		for(Usuario usuario : listaUsuarios)
			System.out.println(usuario);
	}
}
