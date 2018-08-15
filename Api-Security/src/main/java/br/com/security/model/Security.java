package br.com.security.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
public class Security {
	
	@Id
	@Email(message="Email invalido")
	@NotEmpty(message="Campo obrigatório")
	@Column(unique=true)
	private String email;
	
	@NotEmpty(message="Campo obrigatório")
	@Size(min=2, max=120)
	private String nome;
	
	@NotEmpty(message="Campo obrigatório")
	@Size(min=4, max=10, message="Verificar quantidade de caracteres")
	private String password;
	
	@OneToMany(mappedBy="security", cascade=CascadeType.ALL)
	private List<Task> taks;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="SECURITY_ROLES", joinColumns= {
			@JoinColumn(name="SECURITY_EMAIL", referencedColumnName="email")
	}, inverseJoinColumns = {
			@JoinColumn(name="ROLE_NAME", referencedColumnName="nome")
	})
	private List<Role> roles;
		
	public Security() {	}
	
	public Security(String email, String nome, String password, List<Task> taks, List<Role> roles) {
		this.email = email;
		this.nome = nome;
		this.password = password;
		this.taks = taks;
		this.roles = roles;
	}
	

	public Security(String email, String nome, String password) {
		this.email = email;
		this.nome = nome;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Task> getTaks() {
		return taks;
	}
	public void setTaks(List<Task> taks) {
		this.taks = taks;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	

}
