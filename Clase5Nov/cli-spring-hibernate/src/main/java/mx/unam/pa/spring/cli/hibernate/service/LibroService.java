package mx.unam.pa.spring.cli.hibernate.service;

import java.util.List;

import mx.unam.pa.spring.cli.hibernate.model.Libro;

/**
 * 
 *
 * <p>Clase: Programación Avanzada 2020-I</p>
 * @author Gabriel González G.
 * @date Oct 4, 2019, 5:33:17 PM
 *
 */
public interface LibroService {
	/**
	 * Obtiene el listado de todos los libros registrados 
	 * en la tabla <code>libro</code> a través del DAO.
	 * @return
	 */
	public List<Libro> listar();
	
	/**
	 * Guarda un libro en la tabla <code>libro</code>
	 * @param libro
	 */
	public void guardarLibro(Libro libro);
	
	/**
	 * Obtiene un libro por su PK ISBN
	 * @param isbn
	 * @return
	 */
	public Libro getLibro(String isbn);
}
