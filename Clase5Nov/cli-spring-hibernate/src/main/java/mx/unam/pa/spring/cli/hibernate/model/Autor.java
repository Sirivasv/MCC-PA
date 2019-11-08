package mx.unam.pa.spring.cli.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * POJO para mapear la tabla autor
 *
 * Clase: Programación Avanzada 2020-I
 * @author Gabriel González G.
 * @date Aug 18, 2019, 5:28:07 PM
 *
 */
@Entity
@Table(name = "autor")
public class Autor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private short  id;
	
	@Column(name = "nombre", nullable = false, length = 45 )
	private String nombre;
	
	@Column(name = "apellido", nullable = false, length = 45 )
	private String apellido;
	
	@OneToMany(mappedBy = "autor", fetch = FetchType.LAZY)
	private Set<Publicacion> publicaciones = new HashSet<>(); 
	
	public Autor() {
		super();
	}
	
	public Autor(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public short getId() {
		return id;
	}
	
	public void setId(short id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
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
		builder.append("Autor [id=").append(id).append(", nombre=").append(nombre).append(", apellido=")
				.append(apellido).append("]");
		return builder.toString();
	}
}
