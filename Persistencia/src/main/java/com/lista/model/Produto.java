package com.lista.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="tbl_produto")
public class Produto implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="id", sequenceName="id_produto", allocationSize=1)
	@GeneratedValue(generator="id", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Size(min=2, max=60, message="A quantidade de caracteres não pode ser menor que {min} e maior que {max}")
	@NotNull(message="A nome não pode ser nula")
	@NotBlank(message="Informe o nome")
	@Column(name="nome", nullable = false)
	private String nome;
	
	@NotNull(message="A preço não pode ser nula")
	@NotBlank(message="Informe o preço")
	@Column(name="preco", nullable = false, columnDefinition="decimal(12,2)")
	@NumberFormat(style = NumberFormat.Style.CURRENCY)
	private Double preco;
	
	@NotNull(message="A quantidade não pode ser nula")
	@NotBlank(message="Informe o quantidade no estoque")
	@Column(name="quantidade_estoque", nullable = false)
	private Double quantidadeEstoque;
	
	@NotNull(message="A descrica não pode ser nula")
	@NotBlank(message="Informe o descricao")
	@Column(name="descricao", nullable = false)
	private String descricao;
	
	@ManyToMany(fetch= FetchType.LAZY)
	@JoinTable(name="desejo", joinColumns = {
			@JoinColumn(name="produto", referencedColumnName="id", nullable=false)
	}, inverseJoinColumns = {
			@JoinColumn(name="pessoa_fisica", referencedColumnName="id", nullable = false)
	}, uniqueConstraints = {
			@UniqueConstraint(columnNames="pessoa_fisica")
	})
	private List<PessoaFisica> pessoaFisicas = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Marca marca;
	

	public Produto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<PessoaFisica> getPessoaFisicas() {
		return pessoaFisicas;
	}
	public void setPessoaFisicas(List<PessoaFisica> pessoaFisicas) {
		this.pessoaFisicas = pessoaFisicas;
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


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public Double getQuantidadeEstoque() {
		return quantidadeEstoque;
	}


	public void setQuantidadeEstoque(Double quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	

	
	
}
