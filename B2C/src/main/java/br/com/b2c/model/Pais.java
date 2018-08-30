package br.com.b2c.model;

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

@Entity
@Table(name="tbl_pais")
public class Pais implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="id_sequencia", sequenceName="id", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_sequencia")
	private Integer id;
	
	@Column(name="nome", nullable=false, length=60)
	@Size(min=3, max=60, message="Quantidade de caracteres maiores ou menores que a permitida")
	@NotBlank(message="Valor Obrogatório")
	@NotNull(message="Campo requerido")
	private String nome;
	
	@Column(name="iso", nullable=false)
	@Size(max=3, message="Valor do ISO {max} não permitido")
	@NotBlank(message="Campo precisa ser preenchido")
	@NotNull(message="Campo não pode estar vazio")
	private String iso;
	
	public Pais() {
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

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
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
	
	
	
	

}
