package com.form.validator.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="tbl_usuario")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long id;
	
	@NotBlank(message="O nome é obrigatório ....")
	@Column(name="user_nome")
	@Size(min=3, max=120, message="Mínimo 3 e máximo 120")
	private String nome;
	
	@NotBlank(message="O Email é obrigatório ....")
	@Column(name="user_email")
	@Email(message="Email não confore com os padrões.")
	private String email;

	@NotBlank(message="A senha é obrigatório ....")
	@Column(name="user_senha")
	@Size(min=6, max=8, message="Mínimo 6 e máximo 8")
	private String senha;
	
	@NotBlank(message="A idade é obrigatória ....")
	@Column(name="user_idade")
	@Size(min=1, max=3, message="Mínimo 1 e máximo 3 número")
	private String idade;
	
	@NotBlank(message="O telefone é obrigatório ....")
	@Column(name="user_telefone")
	private String telefone;
	
	public User() {
		
	}
	
	
	public User(String nome, String email, String senha, String idade, String telefone) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.idade = idade;
		this.telefone = telefone;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getIdade() {
		return idade;
	}


	public void setIdade(String idade) {
		this.idade = idade;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
	
	

}
