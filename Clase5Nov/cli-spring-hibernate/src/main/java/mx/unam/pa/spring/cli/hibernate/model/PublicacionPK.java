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
	
	@Column(name = "autor_id")
	private short autorId;
	
	@Column(name = "libro_isbn", length = 14)
	private String libroIsbn;

	public PublicacionPK() {
		super();
	}
	
	/**
	 * Constructor completo
	 * @param autorId
	 * @param libroIsbn
	 */
	public PublicacionPK(short autorId, String libroIsbn) {
		super();
		this.autorId = autorId;
		this.libroIsbn = libroIsbn;
	}

	public short getAutorId() {
		return autorId;
	}

	public void setAutorId(short autoresId) {
		this.autorId = autoresId;
	}

	public String getLibroIsbn() {
		return libroIsbn;
	}

	public void setLibroIsbn(String libroIsbn) {
		this.libroIsbn = libroIsbn;
	}

	@Override
	public int hashCode() {
		/*
		 * A partir de la versión 7 de JDK
		 */
		return Objects.hash(autorId, libroIsbn);
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
		return Objects.equals(autorId, other.autorId) &&
				Objects.equals(libroIsbn, other.libroIsbn);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PublicacionPK [autoresId=").append(autorId).append(", librosIsbn=").append(libroIsbn)
				.append("]");
		return builder.toString();
	}
	
}
