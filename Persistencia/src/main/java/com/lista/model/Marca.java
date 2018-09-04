package com.lista.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
@Entity
@Table(name="tbl_marca")
public class Marca implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "id", sequenceName = "id_marca")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
	private Integer id;
	
	@NotBlank(message="Nome não pode estar vazio")
	@NotNull(message="Nome não pode ser nulo")
	@Column(name="nome", nullable=false, length = 90)
	@Length(min=2, max = 90, message="verificar quantidade de nome min = {min} e max = {max}")
	private String nome;
	
	@OneToMany
	@NotBlank(message="Produtos não pode estar vazio")
	@NotNull(message="Produtos não pode ser nulo")
	private List<Produto> produtos = new ArrayList<>();
	
	public Marca() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
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
		Marca other = (Marca) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
