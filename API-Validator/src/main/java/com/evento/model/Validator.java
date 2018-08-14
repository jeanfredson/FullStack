package com.evento.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="api_validator")
public class Validator {
	
	@Id
	@Email(message="Entre com email valido")
	@NotBlank(message="Valor Obrigatório")
	private String email;
	
	@NotBlank(message="Por favor entre com seu nome")
	@Size(min=2, max=120, message="Tamanho do nome invalido")
	private String name;

	@NotBlank(message="Por favor entre com seu nome")
	@Size(min=4, max=8, message="Verificar quantidade de caracteres")
	private String password;

	@NotBlank(message="Informe sua idade")
	@Pattern(regexp="[\\d] {2}", message="Idade invalida")
	private String ano;
	
	@NotBlank(message="Informe seu número de telefone")
	@Pattern(regexp="[\\d] {9}", message="Número de telefone invalido")
	private String telefone;
	
	public Validator() {}
	
	public Validator(String email, String name, String password, String ano, String telefone) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.ano = ano;
		this.telefone = telefone;
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

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
	
	
	

}
