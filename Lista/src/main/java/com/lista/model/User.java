package com.lista.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tbl_user")
public class User {
	
	
	@Id
	@SequenceGenerator(allocationSize=1, name="id", sequenceName="id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id")
	private Long id;
	
	@NotNull(message="não pode ser nullo")
	@NotBlank(message="informar o nome")
	private String nome;
	
	@NotNull(message="Não pode ser nullo")
	@NotBlank(message="informar o telefone")
	private String telefone;
	
	@NotNull(message="não pode ser nullo")
	@NotBlank(message="informar o nascimento")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date nascimento;
	
	
	public User() {
		
	}
	
	public User(String nome, String telefone, Date nascimento) {

		this.nome = nome;
		this.telefone = telefone;
		this.nascimento = nascimento;
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


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public Date getNascimento() {
		return nascimento;
	}


	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
