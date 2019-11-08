package mx.unam.pa.spring.cli.hibernate.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.unam.pa.spring.cli.hibernate.model.Autor;

/**
 * Implementación de la funcionalidad de acceso a los datos 
 * definida en la interfaz {@link AutorDAO}
 *
 * <p>Clase: Programación Avanzada 2020-I</p>
 * @author Gabriel González G.
 * @date Oct 4, 2019, 11:42:08 AM
 *
 */
@Repository
public class AutorDAOImpl implements AutorDAO {
	/**
	 * Se indica al contexto de spring que inyecte 
	 * un bean de tipo {@link SessionFactory}
	 */
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public List<Autor> getAllAuthors() {
		Session session = sessionFactory.getCurrentSession();
		//session.beginTransaction();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		// Se indica al constructor del criterio que el resultado esperado es de tipo Usuario
		CriteriaQuery<Autor> criteria = builder.createQuery(Autor.class);
		
		/* 
		 * La raíz es la referencia al objeto mapeado, en este caso, la raíz es la referencia 
		 * al objeto Autor
		 */
		Root<Autor> root = criteria.from(Autor.class);
		criteria.select(root);
		
		/* 
		 * El listado de objetos devuelto getResultList() corresponde al esperado sin
		 * requerimiento de conversión adicional 
		 */
		Query<Autor> query = session.createQuery(criteria);
		List<Autor> usuarios = query.getResultList();
		
		// Commit de la transacción
		//session.getTransaction().commit();
		
		return usuarios;
	}

	@Override
	public void save(Autor autor) {
		sessionFactory.getCurrentSession().save(autor);
	}

	@Override
	public Autor getAuthor(short id) {
		return sessionFactory.getCurrentSession().get(Autor.class, id);
	}

}
