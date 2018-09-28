package com.lista.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Titulo {
	
	@Id
	@SequenceGenerator(allocationSize=1, name="id", sequenceName="id_titulo")
	@GeneratedValue(generator="id", strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@NotBlank(message="Não pode estar em branca")
	@NotNull(message="Não pode ser nulo")
	@Size(min=5, max=220, message="Verificar a quantidade de caracteres")
	@Column(name="descricao", length=220)
	private String descricao;
	
	@NotBlank(message="Não pode estar em branca")
	@NotNull(message="Não pode ser nulo")
	@Temporal(TemporalType.DATE)
	private Date vencimento;
	
	@NotBlank(message="Não pode estar em branca")
	@NotNull(message="Não pode ser nulo")
	private Double valor;
	
	@Enumerated(EnumType.STRING)
	private Descricao status;
	
	
	public Titulo() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public Descricao getStatus() {
		return status;
	}


	public void setStatus(Descricao status) {
		this.status = status;
	}


	public Date getVencimento() {
		return vencimento;
	}


	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
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
		Titulo other = (Titulo) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}


	
	
	

}
