package io.ponto.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity(name="tbl_user")
public class User {
	
	@Id
	@Email
	@NotEmpty
	@Column(unique=true)
	private String email;
	@NotEmpty
	private String name;
	@Size(min=4)
	private String password;
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Task> taks;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinTable(name="USER_ROLES", joinColumns= {
			@JoinColumn(name="USER_EMAIL", referencedColumnName="email")
	}, inverseJoinColumns = {
			@JoinColumn(name="ROLE_NAME", referencedColumnName="name")
	})
	private List<Role> roles;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	public User(String email, String name, String password) {		
		this.email = email;
		this.name = name;
		this.password = password;
	}



	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
