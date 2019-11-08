package mx.unam.pa.spring.cli.hibernate.dao;

import java.util.List;

import mx.unam.pa.spring.cli.hibernate.model.Autor;

public interface AutorDAO {
	/**
	 * <p>Ejecución de consulta a la tabla autor.</p>
	 * <p>Equivalente a <br><code>SELECT * FROM autor;</code></p>
	 * @return Listado de todos los autores
	 */
	public List<Autor> getAllAuthors();
	
	/**
	 * <p>Ejecución de inserción en la tabla libro.</p>
	 * <p>Equivalente a <br><code>INSERT INTO libro...</code></p>
	 * @param autor
	 */
	public void save(Autor autor);
	
	/**
	 * <p>Ejecución de consulta a la tabla autor con el criterio id.</p>
	 * <p>Equivalente a <br> 
	 * <code>SELECT * FROM libro WHERE id = 3;</code>
	 * </p>
	 * @param id
	 * @return
	 */
	public Autor getAuthor(short id );
}
