package mx.unam.pa.spring.cli;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mx.unam.pa.spring.cli.hibernate.model.Usuario;

/**
 * Clase de demostración del funcionamiento de 
 * Hibernate: Lectura.
 * 
 * Esta clase no se apega a las mejores prácticas 
 * de uso de un objeto DAO y su único propósito es 
 * mostrar un ejemplo conciso. 
 *  
 * Clase: Programación Avanzada 2020-I
 * @author Gabriel González G.
 * @date Aug 16, 2019, 8:13:39 PM
 *
 */
public class Ej01_SimpleHibernate {
	
	/**
	 * Inicialización del objeto de configuración para crear la 
	 * conexión a la DB con los parámetros declarados en el archivo 
	 * de configuración hibernate.cfg.xml
	 */
	public SessionFactory initSessionFactory() {
		System.out.println("Inicializando conexión con la base de datos");
		return new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class)
				.buildSessionFactory();
	}
	
	public static void main(String[] args) {
		Ej01_SimpleHibernate demo = new Ej01_SimpleHibernate();
		
		System.out.println("Interacción con la DB y la tabla mapeada");
		try( SessionFactory factory = demo.initSessionFactory() ){
			
			Session session = factory.getCurrentSession();
			
			// Iniciar una nueva tansacción
			session.beginTransaction();
			
			// Obteniendo la información de un usuario empleando su llave primaria (PK)
			Usuario usuarioLeido = session.get(Usuario.class, "admin@libreria.com");
			
			// Enviar commit a la base de datos
			session.getTransaction().commit();
			
			System.out.println("información del usuario leido: " + usuarioLeido);
		}
	}
}
