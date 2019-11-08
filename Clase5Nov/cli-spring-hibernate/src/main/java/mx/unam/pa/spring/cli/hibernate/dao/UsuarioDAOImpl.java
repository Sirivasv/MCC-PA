package mx.unam.pa.spring.cli.hibernate.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.unam.pa.spring.cli.hibernate.model.Usuario;

/**
 * 
 *
 * Clase: Programación Avanzada 2020-I
 * @author Gabriel González G.
 * @date Sep 8, 2019, 10:26:59 AM
 *
 */
@Repository
public class UsuarioDAOImpl implements UsuarioDAO {
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public Usuario loginUser(Usuario usuario) {
		Session session = sessionFactory.getCurrentSession(); 
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
		
		Root<Usuario> root = criteria.from(Usuario.class);
		
		criteria.select(root).where(
				builder.and( // definición de la condición AND para la cláusula 
						builder.equal(root.get("correo"), usuario.getCorreo()),
						builder.equal(root.get("passwd"), usuario.getPasswd())
				)
			);
		// Ejecución del query
		Query<Usuario> query = session.createQuery(criteria);
		return query.uniqueResult();
	}

	@Override
	public String saveUser(Usuario usuario) {
		System.out.println("saveUser()");
		Session session = sessionFactory.getCurrentSession();
		return (String) session.save(usuario);
	}

	@Override
	public Usuario loadUser(String email) {
		System.out.println("getUser()");
		
		System.out.println("Recuperando el usuario por su PK: " + email);
		Session session = sessionFactory.getCurrentSession();
		return session.load(Usuario.class, email);
	}

}
