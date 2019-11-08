package mx.unam.pa.spring.cli.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Mapeo de un POJO con una tabla a través 
 * de anotaciones a través de la especificación 
 * estándar de JPA.
 *
 * Clase: Programación Avanzada 2020-I
 * @author Gabriel González G.
 * @date Aug 16, 2019, 7:59:43 PM
 *
 */
@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@Column(name="mail")
	private String correo;
	
	@Column(name = "password")
	private String passwd;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido_paterno")
	private String apPaterno;
	
	@Column(name = "apellido_materno")
	private String apMaterno;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "admin")
	private boolean admin;
	
	/**
	 * Constructor sin argumentos requerido
	 */
	public Usuario() {}
	
	/**
	 * Constructor completo
	 * @param correo
	 * @param passwd
	 * @param nombre
	 * @param apPaterno
	 * @param apMaterno
	 * @param admin
	 */
	public Usuario(String correo, String passwd, String nombre, String apPaterno, String apMaterno, String telefono, boolean admin) {
		super();
		this.correo = correo;
		this.passwd = passwd;
		this.nombre = nombre;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.telefono = telefono;
		this.admin = admin;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApPaterno() {
		return apPaterno;
	}
	
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	
	public String getApMaterno() {
		return apMaterno;
	}
	
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean isAdmin() {
		return admin;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [correo=").append(correo).append(", passwd=").append(passwd).append(", nombre=")
				.append(nombre).append(", apPaterno=").append(apPaterno).append(", apMaterno=").append(apMaterno)
				.append(", telefono=").append(telefono).append(", admin=").append(admin).append("]");
		return builder.toString();
	}

}
