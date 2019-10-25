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
 * Selección de campos específicos. 
 * Equivalente a
 * <code>SELECT nombre, apellido_paterno FROM usuario;</code>
 * 
 * Clase: Programación Avanzada 2020-I
 * @author Gabriel González G.
 * @date Aug 18, 2019, 4:15:54 PM
 *
 */
public class Ej05_HibernateCriteriaExpresiones2 extends Ej03_HibernateCriteriaIntro {
	public static void main(String[] args) {
		Ej05_HibernateCriteriaExpresiones2 demo = new Ej05_HibernateCriteriaExpresiones2();
		
		try( SessionFactory factory = demo.initSessionFactory() ){
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			/*
			 * Selección de múltiples columnas
			 */
			CriteriaBuilder builder = session.getCriteriaBuilder();
			
			CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
			Root<Usuario> root = criteria.from(Usuario.class);
			
			// Selección de las columnas de interés
			criteria.multiselect(root.get("nombre"),root.get("apPaterno"));
			
			Query<Object[]> query = session.createQuery(criteria);
			List<Object[]> listaObjetos = query.getResultList();
			
			for( Object[] objs : listaObjetos ) {
				System.out.println("Nombre: " + objs[0]);
				System.out.println("Apellido Paterno: " + objs[1]);
			}
			
			session.getTransaction().commit();
		}
	}
}
