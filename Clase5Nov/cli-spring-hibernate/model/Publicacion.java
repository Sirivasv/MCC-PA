package mx.unam.pa.spring.cli.hibernate.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Pojo para mapear la tabla publicacion, la cual  
 * funciona como una tabla intermedia entre autor y 
 * libro, y que se identifica por una llave compuesta. 
 * Dado que se tiene una columna adicional, no es posible 
 * utilizar la anotacion {@link ManyToMany}.  
 *
 * <br>
 * Clase: Programación Avanzada 2020-I
 * @author Gabriel González G.
 * @date Aug 18, 2019, 5:40:38 PM
 *
 */
@Entity
@Table(name = "publicacion")
public class Publicacion {
	@EmbeddedId
	private PublicacionPK id;
	
	@ManyToOne
	@MapsId("id") // Nombre del atributo del POJO Autor que está etiquetado como ID
	private Autor autor;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@MapsId("isbn") // Nombre del atributo del POJO Libro que está etiquetado como ID
	private Libro libro;
	
	@Column(name = "anio_publicacion")
	private Date fechaPublicacion;
	
	public Publicacion() {
		super();
	}

	/**
	 * Constructor completo
	 * @param id
	 * @param autor
	 * @param libro
	 * @param anio
	 */
	public Publicacion(Autor autor, Libro libro, Date fechaPublicacion) {
		super();
		this.id = new PublicacionPK(autor.getId(), libro.getIsbn());
		this.autor = autor;
		this.libro = libro;
		this.fechaPublicacion = fechaPublicacion;
	}

	

	public PublicacionPK getId() {
		return id;
	}

	public void setId(PublicacionPK id) {
		this.id = id;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
}
