package com.lista.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="tbl_estado")
public class Estado {
	
	
	@Id
	@SequenceGenerator(allocationSize=1, name="id", sequenceName="id_estado")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id")
	private Integer id;
	
	@NotNull(message="Nome não pode estar vazio")
	@NotBlank(message="Nome deve ser fornecido")
	@Length(min=2, max=90, message="Valores {min} e {max} dever ser respeitados")
	@Column(name="nome", length=90)
	private String nome;
	
	@NotNull(message="Nome não pode estar vazio")
	@NotBlank(message="Nome não fornecido")
	@Column(name="uf", length=2)
	@Size(max=2, message="Verificar quantidade de {max} para o campo")
	private String uf;
	
	@ManyToOne
	@JoinColumn(name="pais", referencedColumnName="id", nullable= false)
	private Pais pais;

	
	public Estado() {
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
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
		Estado other = (Estado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
