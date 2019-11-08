package mx.unam.pa.spring.cli.hibernate.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * POJO para mapear la tabla genero
 *
 * Clase: Programación Avanzada 2020-I
 * @author Gabriel González G.
 * @date Aug 19, 2019, 8:55:14 PM
 *
 */
@Entity
@Table(name = "genero")
public class Genero {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_generos")
	private short idGenero;
	
	@Column(name = "nombre", nullable = false, length = 45)
	private String nombre;
	
	@OneToMany
	@JoinColumn(name = "generos_id_generos")
	private Set<Libro> libros;

	public Genero() {
		super();
	}

	public Genero(String nombre) {
		super();
		this.nombre = nombre;
	}

	public short getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(short idGenero) {
		this.idGenero = idGenero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Genero [idGenero=").append(idGenero).append(", nombre=").append(nombre).append("]");
		return builder.toString();
	}
}
