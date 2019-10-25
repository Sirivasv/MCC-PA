package mx.unam.pa.spring.cli;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import mx.unam.pa.spring.cli.hibernate.model.Usuario;

public class Ej01a_SimpleHibernate extends Ej01_SimpleHibernate{
	public static void main(String[] args) {
		Ej01a_SimpleHibernate demo = new Ej01a_SimpleHibernate();
		
		System.out.println("Interacción con la DB y la tabla mapeada");
		try( SessionFactory factory = demo.initSessionFactory() ){
			
			Session session = factory.getCurrentSession();
			
			// Creación del POJO a persistir
			Usuario usuario = new Usuario("hdent@mail.com", "supersecreto", "Harvey", "Dent", null, "55555", false);
			
			// Inicio de la transacción con la base de dato
			session.beginTransaction();
			
			// insertar el registro en la tabla usuario
			session.save(usuario);
			
			// Enviar commit a la base de datos
			session.getTransaction().commit();
			
			System.out.println("Usuario almacenado en la base de datos");
			
			System.out.println("\n========================================\n");
			
			System.out.println("Recuperación del usuario almacenado");
			
			
		}
	}
}
