package com.lista.model;

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
@Table(name="tbl_tipo_endereco")
public class TipoEndereco {
	
	@Id
	@SequenceGenerator(name="id", sequenceName="id_tipo_endereco", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id")
	private Integer id;
	
	@NotNull(message="descricao não deve ser vazio")
	@NotBlank(message="descricao deve ser informado")
	@Size(min=2, max=120, message="descricao deve ter no mínimo {min} e no máximo {max}")
	@Column(name="descricao", length=120)
	private String descricao;
	
	
	public TipoEndereco() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
		TipoEndereco other = (TipoEndereco) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}
	
	

}
