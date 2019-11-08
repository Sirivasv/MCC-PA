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

import mx.unam.pa.spring.cli.hibernate.model.Libro;

/**
 * 
 *
 * Clase: Programación Avanzada 2020-I
 * @author Gabriel González G.
 * @date Sep 7, 2019, 2:29:26 PM
 *
 */
@Repository
public class LibroDAOImpl implements LibroDAO{
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public List<Libro> getAllBooks() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Libro> criteria = builder.createQuery(Libro.class);
		Root<Libro> root = criteria.from(Libro.class);
		criteria.select(root);
		Query<Libro> query = session.createQuery(criteria);
		return query.getResultList();
	}

	@Override
	public void save(Libro libro) {
		Session session = sessionFactory.getCurrentSession();
		session.save(libro);
	}

	@Override
	public Libro getBook(String isbn) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Libro.class, isbn);
	}

}
