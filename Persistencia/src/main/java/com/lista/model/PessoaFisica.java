package com.lista.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name="tbl_pf")
public class PessoaFisica extends Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Size(min=9, max=16, message="A quantidade de caracteres não pode ser menor que {min} e maior que {max}")
	@NotNull(message="A rg estadual não pode ser nula")
	@NotBlank(message="Informe o rg")
	@Column(name="rg", nullable = false)
	private String rg;
	
	@CPF(message="CPF INVALIDO")
	@NotNull(message="A cpf não pode ser nula")
	@NotBlank(message="Informe o cpf")
	@Column(name="cpf", nullable = false)
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	@NotNull(message="A data de nascimento não pode ser nula")
	@NotBlank(message="Informe a data de nascimento")
	@Column(name="data_nascimento", nullable = false)
	private Calendar dataNascimento;
	
	@Size(min=2, max=60, message="A quantidade de caracteres não pode ser menor que {min} e maior que {max}")
	@NotNull(message="A nome do usuário não pode ser nula")
	@NotBlank(message="Informe o nome do usuário")
	@Column(name="nome_usuario", nullable = false)
	private String nomeUsuario;
	
	
	@Size(min=6, max=8, message="A senha não pode ser menor que {min} e maior que {max}")
	@NotNull(message="A senha não pode ser nula")
	@NotBlank(message="Informe a senha")
	@Column(name="senha", nullable = false)
	private String senha;
	
	
	@ManyToMany(fetch = FetchType.LAZY) // faz o carregamento
	@JoinTable(name="desejo", joinColumns = {
			@JoinColumn(name="pessoa_fisica", referencedColumnName = "id", nullable = false)
	}, inverseJoinColumns = {
			@JoinColumn(name="produto", referencedColumnName="id", nullable=false)
	}, uniqueConstraints = {
			@UniqueConstraint(columnNames = {"pessoa_fisica"})
	})
	private List<Produto> produtos = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "join_permissoes", joinColumns = {
			@JoinColumn(name="nome_usuario", referencedColumnName = "nome_usuario", nullable = false)
	}, inverseJoinColumns = {
			@JoinColumn(name="permissao", referencedColumnName = "nome", nullable = false)
	}, uniqueConstraints = {
			@UniqueConstraint(columnNames = {"nome_usuario", "permissao"})
	})
	private List<Permissao> permissaos = new ArrayList<>();
		
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public PessoaFisica() {
		// TODO Auto-generated constructor stub
	}



	public String getRg() {
		return rg;
	}



	public void setRg(String rg) {
		this.rg = rg;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public Calendar getDataNascimento() {
		return dataNascimento;
	}



	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}



	public String getNomeUsuario() {
		return nomeUsuario;
	}



	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
