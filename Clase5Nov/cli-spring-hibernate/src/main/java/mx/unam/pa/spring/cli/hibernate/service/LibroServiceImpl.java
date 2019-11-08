package mx.unam.pa.spring.cli.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.unam.pa.spring.cli.hibernate.dao.LibroDAO;
import mx.unam.pa.spring.cli.hibernate.model.Libro;

@Service
@Transactional
public class LibroServiceImpl implements LibroService {
	@Autowired
	private LibroDAO dao;
	
	@Override
	public List<Libro> listar() {
		return dao.getAllBooks();
	}

	@Override
	public void guardarLibro(Libro libro) {
		dao.save(libro);
	}

	@Override
	public Libro getLibro(String isbn) {
		return dao.getBook(isbn);
	}

}
