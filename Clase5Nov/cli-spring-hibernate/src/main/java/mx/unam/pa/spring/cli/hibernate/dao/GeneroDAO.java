package mx.unam.pa.spring.cli.hibernate.dao;

import java.util.List;

import mx.unam.pa.spring.cli.hibernate.model.Genero;

/**
 * <p>
 * Declaración de los métodos que el objeto de 
 * acceso a datos (DAO) para genero deberá implementar.
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
 * @date Sep 7, 2019, 6:53:25 PM
 *
 */
public interface GeneroDAO {
	
	/**
	 * Ejecución de consulta a la tabla genero
	 * Equivalente a SELECT * FROM genero;
	 * @return Listado de todos los generos
	 */
	public List<Genero> getAllGenres();
	
	/**
	 * Ejecución de inserción en la tabla genero.
	 * Equivalente a INSERT INTO genero...
	 * @param genre
	 */
	public void save(Genero genre);
	
	/**
	 * Ejecución de consulta a la tabla genero con el criterio idGenero
	 * Equivalente a 
	 * SELECT * FROM genero WHERE idGenero = 1;
	 * @param id
	 * @return 
	 */
	public Genero getGenre(short id);
}
