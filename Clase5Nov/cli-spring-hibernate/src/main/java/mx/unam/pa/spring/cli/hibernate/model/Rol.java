package mx.unam.pa.spring.cli.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "rol_id")
	private short rolId;
	
	@Column(name = "rol_nombre", nullable = false, length = 45)
	private String roleNombre;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "rol_has_privilegio", // Nombre de la tabla intermedia en la base de datos
			joinColumns = { @JoinColumn(name = "rol_rol_id") }, // nombre del campo de la tabla intermedia que representa la FK del rol
			inverseJoinColumns = @JoinColumn(name = "privilegio_priv_id") // nombre del campo de la tabla intermedia que representa la FK del privilegio
		)
	private Set<Privilegio> privilegios = new HashSet<>();
	
	public short getRolId() {
		return rolId;
	}

	public void setRolId(short rolId) {
		this.rolId = rolId;
	}

	public String getRoleNombre() {
		return roleNombre;
	}

	public void setRoleNombre(String roleNombre) {
		this.roleNombre = roleNombre;
	}

	public Set<Privilegio> getPrivilegios() {
		return privilegios;
	}

	public void setPrivilegios(Set<Privilegio> privilegios) {
		this.privilegios = privilegios;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rol [rolId=").append(rolId).append(", roleNombre=").append(roleNombre).append("]");
		return builder.toString();
	}
}
