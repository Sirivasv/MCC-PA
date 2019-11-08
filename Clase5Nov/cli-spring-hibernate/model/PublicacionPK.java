package mx.unam.pa.spring.cli.hibernate.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Definición de un POJO que será empleado como 
 * llave compuesta para la tabla intermedia 
 * publicacion, cuya llave primaria (PK) es 
 * <code>PRIMARY KEY (`autores_id`,`libros_isbn`)</code>.<br>
 * Como se observa, se requieren dos campos que a su vez, 
 * representan una relación M:1 con su respectiba tabla.
 * 
 * Este POJO será anotado con {@link Embeddable}. Por sí solo,
 * este POJO no representa una entidad.
 * 
 * Clase: Programación Avanzada 2020-I
 * @author Gabriel González G.
 * @date Aug 20, 2019, 9:45:42 PM
 *
 */
@Embeddable
public class PublicacionPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "autores_id")
	private short autoresId;
	
	@Column(name = "libros_isbn", length = 14)
	private String librosIsbn;

	public PublicacionPK() {
		super();
	}
	
	/**
	 * Constructor completo
	 * @param autoresId
	 * @param librosIsbn
	 */
	public PublicacionPK(short autoresId, String librosIsbn) {
		super();
		this.autoresId = autoresId;
		this.librosIsbn = librosIsbn;
	}

	public short getAutoresId() {
		return autoresId;
	}

	public void setAutoresId(short autoresId) {
		this.autoresId = autoresId;
	}

	public String getLibrosIsbn() {
		return librosIsbn;
	}

	public void setLibrosIsbn(String librosIsbn) {
		this.librosIsbn = librosIsbn;
	}

	@Override
	public int hashCode() {
		/*
		 * A partir de la versión 7 de JDK
		 */
		return Objects.hash(autoresId, librosIsbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		
		PublicacionPK other = (PublicacionPK) obj;
		/*
		 * A partir de la version 7 del JDK
		 */
		return Objects.equals(autoresId, other.autoresId) &&
				Objects.equals(librosIsbn, other.librosIsbn);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PublicacionPK [autoresId=").append(autoresId).append(", librosIsbn=").append(librosIsbn)
				.append("]");
		return builder.toString();
	}
	
}
