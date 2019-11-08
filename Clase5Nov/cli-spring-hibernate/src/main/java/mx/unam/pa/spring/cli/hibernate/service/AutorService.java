package mx.unam.pa.spring.cli.hibernate.service;

import java.util.List;

import mx.unam.pa.spring.cli.hibernate.model.Autor;

/**
 * Clase de servicio que permitira definir la funcionalidad que 
 * se dará entre el DAO y la aplicación que la consuma
 *
 * <p>Clase: Programación Avanzada 2020-I</p>
 * @author Gabriel González G.
 * @date Oct 4, 2019, 4:45:20 PM
 *
 */
public interface AutorService {
	public List<Autor> listarAutores();
	
	/**
	 * Inserción de un POJO {@link Autor} en la base de 
	 * datos
	 * @param autor
	 */
	public void guardar(Autor autor);
}
