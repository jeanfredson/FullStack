package com.lista.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name="tbl_pais")
public class Pais implements Serializable{

	
	@Id
	@SequenceGenerator(name="seq_pais", sequenceName="seq_pais_id", allocationSize=1)
	@GeneratedValue(generator="seq_pais", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Length(max=50, min=2, message="O Nome não pode ter mais que {max} ou menos que {min} caracteres ...")
	@NotBlank(message="Nome tem que ser informado")
	@NotNull(message="O nome não pode ser nulo")
	@Size(max=20, min=2)
	@Column(name="nome", nullable=false, length=120)
	private String nome;
	
	@Length(max=50, min=2, message="O Nome não pode ter mais que {max} ou menos que {min} caracteres ...")
	@NotBlank(message="Nome tem que ser informado")
	@NotNull(message="O nome não pode ser nulo")
	@Size(max=20, min=2)
	@Column(name="iso", nullable=false, length = 3)
	private String iso;
	
	
	public Pais() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Pais(Integer id, String nome, String iso) {
		this.id = id;
		this.nome = nome;
		this.iso = iso;
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
		Pais other = (Pais) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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
	public String getIso() {
		return iso;
	}
	public void setIso(String iso) {
		this.iso = iso;
	}
	
	

}
