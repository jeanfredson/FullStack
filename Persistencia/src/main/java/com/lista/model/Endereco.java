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

@Entity
@Table(name="tbl_endereco")
public class Endereco {
	
	@Id
	@SequenceGenerator(name="id", sequenceName="id_endereco", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id")
	private Integer id;
	
	@NotNull(message="Nick não deve ser vazio")
	@NotBlank(message="Nick deve ser informado")
	@Size(min=2, max=60, message="Nick deve ter no mínimo {min} e no máximo {max}")
	@Column(name="nick_name", length=60)
	private String nickName;
	
	@NotNull(message="Endereço não deve ser vazio")
	@NotBlank(message="Endereço deve ser informado")
	@Size(min=2, max=60, message="Endereço deve ter no mínimo {min} e no máximo {max}")
	@Column(name="endereco", length=60)
	private String endereco;
	
	@NotNull(message="Número não deve ser vazio")
	@NotBlank(message="Número deve ser informado")
	@Size(min=1, max=6, message="Número deve ter no mínimo {min} e no máximo {max}")
	@Column(name="numero", length=60)
	private String numero;
	
	@NotNull(message="complemento não deve ser vazio")
	@NotBlank(message="complemento deve ser informado")
	@Size(min=2, max=6, message="complemento deve ter no mínimo {min} e no máximo {max}")
	@Column(name="complemento", length=60)
	private String complemento;
	
	@NotNull(message="cep não deve ser vazio")
	@NotBlank(message="cep deve ser informado")
	@Size(max=9, message="cep deve ter no máximo {max}")
	@Column(name="cep", length=60)
	private String cep;
	
	@NotNull(message="bairro não deve ser vazio")
	@NotBlank(message="bairro deve ser informado")
	@Size(min=2, max=60, message="complemento deve ter no mínimo {min} e no máximo {max}")
	@Column(name="bairro", length=60)
	private String bairro;
	
	@NotNull(message="referencia não deve ser vazio")
	@NotBlank(message="referencia deve ser informado")
	@Size(min=2, max=120, message="referencia deve ter no mínimo {min} e no máximo {max}")
	@Column(name="referencia", length=120)
	private String referencia;
	
	@NotNull(message = "A pessoa deve ser informada")
	@ManyToOne
	@JoinColumn(name="id_pessoa", referencedColumnName="id")
	private Pessoa pessoa;
	
	@NotNull(message = "O tipo de endereço deve ser informada")
	@ManyToOne
	@JoinColumn(name="id_tipoEndereco", referencedColumnName="id", nullable=false)
	private TipoEndereco tipoEndereco;
	
	@ManyToOne
	@JoinColumn(name="id_cidade", referencedColumnName="id", nullable=false)
	@NotNull(message = "A cidade deve ser informada")
	private Cidade cidade;
	

	
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}
	
	
	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}
	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getReferencia() {
		return referencia;
	}


	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
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
		Endereco other = (Endereco) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		return true;
	}
	
	

}
