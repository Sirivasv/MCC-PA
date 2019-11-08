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

import mx.unam.pa.spring.cli.hibernate.model.Genero;

@Repository
public class GeneroDAOImpl implements GeneroDAO {
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public List<Genero> getAllGenres() {
		Session session = sessionFactory.getCurrentSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Genero> criteria = builder.createQuery(Genero.class);
		Root<Genero> root = criteria.from(Genero.class);
		criteria.select(root);
		Query<Genero> query = session.createQuery(criteria);
		return query.getResultList();
	}

	@Override
	public void save(Genero genre) {
		Session session = sessionFactory.getCurrentSession();
		session.save(genre);
	}

	@Override
	public Genero getGenre(short id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Genero.class, id);
	}

}
