package mx.unam.pa.spring.cli.hibernate.dao;

import java.util.List;

import mx.unam.pa.spring.cli.hibernate.model.Libro;

/**
 * <p>
 * Declaración de los métodos que el objeto de 
 * acceso a datos (DAO) para libro deberá implementar.
 * </p>
 * <p>
 * Los nombres de los métodos fueron deliberadamente 
 * escritos en inglés, con el único propósito de que 
 * pudieran ser diferenciados de forma más sencilla 
 * de otros similares, i.e. las clases de servicio.
 * </p>
 * <p>
 * Clase: Programación Avanzada 2020-I
 * </p>
 * @author Gabriel González G.
 * @date Sep 7, 2019, 2:23:00 PM
 *
 */
public interface LibroDAO {
	/**
	 * Ejecución de consulta a la tabla libro.<br>
	 * Equivalente a <code>SELECT * FROM libro;</code>
	 * @return Listado de todos los libros
	 */
	public List<Libro> getAllBooks();
	
	/**
	 * Ejecución de inserción en la tabla libro.
	 * Equivalente a INSERT INTO libro...
	 * @param libro
	 */
	public void save(Libro libro);
	
	/**
	 * Ejecución de consulta a la tabla libro con el criterio ISBN
	 * Equivalente a 
	 * SELECT * FROM libro WHERE isbn = 'xxxx';
	 * @param isbn
	 * @return
	 */
	public Libro getBook(String isbn);
	
}
