package mx.unam.pa.spring.cli.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "privilegio")
public class Privilegio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "priv_id")
	private short privId;
	
	@Column(name = "priv_nombre", nullable = false, length = 45)
	private String privName;

	@ManyToMany(mappedBy = "privilegios") // nombre de la variable local de la clase rol que ya define la relación M:M
	private Set<Rol> roles = new HashSet<>();
	
	public short getPrivId() {
		return privId;
	}

	public void setPrivId(short privId) {
		this.privId = privId;
	}

	public String getPrivName() {
		return privName;
	}

	public void setPrivName(String privName) {
		this.privName = privName;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Privilegio [privId=").append(privId).append(", privName=").append(privName).append("]");
		return builder.toString();
	}
}
