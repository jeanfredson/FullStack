package com.lista.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="tbl_permissao")
public class Permissao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Size(min=2, max=90, message="Atentar-se a quantidade de caracteres")
	@NotNull(message="A nome não pode ser nula")
	@NotBlank(message="Informe o nome")
	@Column(name="nome", nullable = false, length = 90)
	private String nome;
	
	@Size(min=5, max=60, message="Atentar-se a quantidade de caracteres")
	@NotNull(message="A descricao não pode ser nula")
	@NotBlank(message="Informe a descricao")
	@Column(name="descricao", nullable = false)
	private String descricao;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "joint_permissoes", joinColumns = {
			@JoinColumn(name="permissao", referencedColumnName = "nome", nullable = false)
	}, inverseJoinColumns = {
			@JoinColumn(name="nome_usuario", referencedColumnName = "nome_usuario", nullable = false)
	}, uniqueConstraints = {
			@UniqueConstraint(columnNames = {"permissao", "nome_usuario"})
	})
	private List<PessoaFisica> pessoaFisicas = new ArrayList<>();
	
	public Permissao() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
