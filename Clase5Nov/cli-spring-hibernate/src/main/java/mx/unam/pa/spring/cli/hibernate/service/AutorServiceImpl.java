package mx.unam.pa.spring.cli.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.unam.pa.spring.cli.hibernate.dao.AutorDAO;
import mx.unam.pa.spring.cli.hibernate.model.Autor;

/**
 * Implementacion de la funcionalidad del servicio.
 * El manejo de las transacciones se delegará al contexto de 
 * Spring al emplearla etiqueta @Transactional
 *
 * <p>Clase: Programación Avanzada 2020-I</p>
 * @author Gabriel González G.
 * @date Oct 4, 2019, 4:47:39 PM
 *
 */
@Service
@Transactional
public class AutorServiceImpl implements AutorService {
	@Autowired
	private AutorDAO dao;
	
	@Override
	public List<Autor> listarAutores() {
		return dao.getAllAuthors();
	}

	@Override
	public void guardar(Autor autor) {
		dao.save(autor);
	}
}
