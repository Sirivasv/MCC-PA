package mx.unam.pa.spring.cli.hibernate.dao;

import java.util.List;

import mx.unam.pa.spring.cli.hibernate.model.Publicacion;
import mx.unam.pa.spring.cli.hibernate.model.PublicacionPK;

/**
 * <p>
 * Declaración de los métodos que el objeto de 
 * acceso a datos (DAO) para publicacion deberá implementar.
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
 * @date Sep 7, 2019, 7:04:26 PM
 *
 */
public interface PublicacionDAO {
	/**
	 * <p>Ejecución de consulta a la tabla publicacion.</p>
	 * <p>Equivalente a <br><code>SELECT * FROM publicacion;</code></p>
	 * @return Listado de todas las publicaciones
	 */
	public List<Publicacion> getAllPublications();
	
	/**
	 * <p>Ejecución de inserción en la tabla publicacion.</p>
	 * <p>Equivalente a <br><code>INSERT INTO publicacion...</code></p>
	 * @param publicacion
	 */
	public void save(Publicacion publicacion);
	
	/**
	 * <p>Ejecución de consulta a la tabla autor con el criterio de PK compuesta.</p>
	 * <p>Equivalente a <br> 
	 * <code>SELECT * FROM publicacion WHERE id = 3;</code>
	 * </p>
	 * @return
	 */
	public Publicacion getPublication(PublicacionPK id);
}
