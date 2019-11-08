package mx.unam.pa.spring.cli.hibernate.dao;

import mx.unam.pa.spring.cli.hibernate.model.Usuario;

/**
 * <p>
 * Declaración de los métodos que el objeto de 
 * acceso a datos (DAO) para usuario deberá implementar.
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
 * @date Sep 8, 2019, 10:27:04 AM
 *
 */
public interface UsuarioDAO {
	/**
	 * Búsqueda de un un usuario empleando su correo 
	 * y contraseña. Estos valores serán extraidos del 
	 * POJO recibido como parámetro.
	 * @param usuario
	 * @return Objeto usuario completo
	 */
	public Usuario loginUser(Usuario usuario);
	
	/**
	 * Insertar el registro del nuevo usuario en la tabla correspondiente
	 * @param usuario
	 */
	public String saveUser(Usuario usuario);
	
	/**
	 * Recuperación del usuario por su llave primaria
	 * @param email
	 * @return
	 */
	public Usuario loadUser(String email);
}
