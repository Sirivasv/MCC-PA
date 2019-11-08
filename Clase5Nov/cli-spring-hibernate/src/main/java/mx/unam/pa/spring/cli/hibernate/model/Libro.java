package mx.unam.pa.spring.cli.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * POJO para mapear la tabla libro
 *
 * Clase: Programación Avanzada 2020-I
 * @author Gabriel González G.
 * @date Aug 18, 2019, 5:34:34 PM
 *
 */
@Entity
@Table(name = "libro")
public class Libro {
	@Id
	@Column(name = "isbn", length = 14)
	private String isbn;
	
	@Column(name = "titulo", nullable = false, length = 255)
	private String titulo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "generos_id_generos")
	private Genero genero;
	
	@OneToMany(mappedBy = "libro", fetch = FetchType.LAZY)
	private Set<Publicacion> publicaciones = new HashSet<>();
	
	public Libro() {}
	
	public Libro(String isbn, String titulo) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
	}

	/**
	 * Constructor completo
	 * @param isbn
	 * @param titulo
	 * @param genero
	 */
	public Libro(String isbn, String titulo, Genero genero) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.genero = genero;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Set<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(Set<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Libro [isbn=").append(isbn).append(", titulo=").append(titulo).append(", genero=\n\t")
				.append(genero).append("]");
		return builder.toString();
	}
}
