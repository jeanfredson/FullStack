package com.lista.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

@Entity
@Table(name="tbl_pj")
public class PessoaJuridica extends Pessoa implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Size(min=6, max=15, message="A quantidade de caracteres não pode ser menor que {min} e maior que {max}")
	@NotNull(message="A inscricao estadual não pode ser nula")
	@NotBlank(message="Informe a inscrição estadual")
	@Column(name="inscricao_estadual", nullable = false)
	private String ie;
	
	
	@CNPJ(message="CNPJ INVALIDO")
	@NotBlank(message="Informe o CNPJ")
	@NotNull(message="CNPJ não pode ser nulo")
	@Column(name="cnpj", nullable=false)
	private String cnpj;
	
	public PessoaJuridica() {
		// TODO Auto-generated constructor stub
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	

}
