package mx.unam.pa.spring.cli;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import mx.unam.pa.spring.cli.hibernate.model.Usuario;

/**
 * Uso del API de Criteria para la creación de queries 
 * con un completo estilo orientado a objetos y con un 
 * manejo seguro de tipos.
 * 
 * ver: https://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#criteria
 *
 * Clase: Programación Avanzada 2020-I
 * @author Gabriel González G.
 * @date Aug 17, 2019, 6:23:19 PM
 *
 */
public class Ej03_HibernateCriteriaIntro extends Ej02_HibernateQueries{
	public static void main(String[] args) {
		Ej03_HibernateCriteriaIntro demo = new Ej03_HibernateCriteriaIntro();
		
		try( SessionFactory factory = demo.initSessionFactory() ){
			
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			
			// Se indica al constructor del criterio que el resultado esperado es de tipo Usuario
			CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
			
			/* 
			 * La raíz es la referencia al objeto mapeado, en este caso, la raíz es la referencia 
			 * al objeto Usuario
			 */
			Root<Usuario> root = criteria.from(Usuario.class);
			criteria.select(root);
			
			Query<Usuario> query = session.createQuery(criteria);
			/* 
			 * El listado de objetos devuelto getResultList() corresponde al esperado sin
			 * requerimiento de conversión adicional 
			 */
			List<Usuario> usuarios = query.getResultList();
			
			System.out.println("Resultados obtenidos a través de criteria");
			demo.imprimirLista(usuarios);
			
			session.getTransaction().commit();
		}
	}
}
