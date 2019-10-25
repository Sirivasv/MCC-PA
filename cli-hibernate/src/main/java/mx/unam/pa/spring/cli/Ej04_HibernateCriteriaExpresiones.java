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
 * Ejemplo de uso de expresiones de Criteria.
 * Descomentar los bloques según sea el caso
 * 
 * Clase: Programación Avanzada 2020-I
 * @author Gabriel González G.
 * @date Aug 17, 2019, 7:16:58 PM
 *
 */
public class Ej04_HibernateCriteriaExpresiones extends Ej03_HibernateCriteriaIntro {
	public static void main(String[] args) {
		Ej04_HibernateCriteriaExpresiones demo = new Ej04_HibernateCriteriaExpresiones();
		
		try( SessionFactory factory = demo.initSessionFactory() ){
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
			
			Root<Usuario> root = criteria.from(Usuario.class);
			
			// Definición de los criterios de búsqueda que se desean aplicar
			/* 
			 * Equivale a
			 * SELECT * FROM usuario WHERE correo LIKE 'e%'
			 */
			criteria.select(root).where( 
					builder.like( root.get("correo"), "e%") 
				);
			
			/*
			 * Equivale a 
			 * SELECT * FROM usuario WHERE apellido_materno IS NOT NULL 
			 */
			/*criteria.select(root).where( 
					builder.isNotNull( root.get("apMaterno") ) 
				);
			*/
			/*
			 * Múltiples condiciones
			 */
			/*criteria.select(root).where(
					builder.and( // definición de la condición AND para la cláusula 
							builder.equal(root.get("correo"), "grimheart@gmail.com"),
							builder.equal(root.get("passwd"), "patito123")
					)
				);
			*/
			/*
			 * Ordenamiento. 
			 * Equivalente a incluir
			 * SELECT ...
			 * ORDER BY nombre, apellido_paterno
			 */
			/*
			criteria.orderBy(
					builder.asc(root.get("nombre")),
					builder.asc(root.get("apPaterno"))
				);
			*/
			
			/*
			criteria.select(root).where( 
				builder.and(
						builder.isNotNull( root.get("apMaterno") ),
						builder.like( root.get("passwd"), "%o"),
						builder.like( root.get("apPaterno"), "k%")
					)
				).orderBy(
					builder.asc(root.get("nombre")),
					builder.asc(root.get("apPaterno"))
				);
			*/
			
			// Ejecución del query
			Query<Usuario> query = session.createQuery(criteria);
			List<Usuario> usuarios = query.getResultList();
			
			demo.imprimirLista(usuarios);
		}
	}
}
