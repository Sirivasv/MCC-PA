package mx.unam.pa.spring.cli;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import mx.unam.pa.spring.cli.hibernate.model.Usuario;

/**
 * Aplicación de funciones agregadas de SQL tales como:
 * <ul>
 * 	<li>COUNT</li>
 * 	<li>AVG</li>
 * 	<li>MAX</li>
 * 	<li>MIN</li>
 * </ul>
 *
 * Ver <a href="https://dev.mysql.com/doc/refman/8.0/en/group-by-functions.html">Aquí</a><br>
 * 
 * Clase: Programación Avanzada 2020-I
 * @author Gabriel González G.
 * @date Aug 18, 2019, 5:01:50 PM
 *
 */
public class Ej06_HibernateCriteriaAggregate extends Ej01_SimpleHibernate{
	public static void main(String[] args) {
		Ej06_HibernateCriteriaAggregate demo = new Ej06_HibernateCriteriaAggregate();
		
		try( SessionFactory factory = demo.initSessionFactory() ){
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Conteo del número de usuarios en la tabla
			CriteriaBuilder builder = session.getCriteriaBuilder();
	
			// El tipo de resultado esperado será numérico
			CriteriaQuery <Long> criteria = builder.createQuery(Long.class);
			
			Root<Usuario> root = criteria.from(Usuario.class);
			criteria.select( builder.count(root) );
			
			/*
			 * Equivalente a 
			 * SELECT COUNT(*) FROM usuario
			 */
			Query<Long> query = session.createQuery(criteria);
			// Recuperar el único resultado que se obtendrá de la consulta
			long total = query.getSingleResult();
			
			System.out.println("Total de usuario: " + total);
			
			session.getTransaction().commit();
		}
	}
}
