package com.api.validator.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="evento")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="evento_id")
	private Long id;
	
	@NotBlank(message="Nome é obrigatório")
	@Size(min=2, max=120)
	@Column(name="usuario")
	private String nome;
	
	@NotBlank(message="CPF é obrigatório")
	@Size(min=13, max=14)
	@Column(name="cpf")
	private String cpf;
	
	@NotBlank(message="Nome é obrigatório")
	@Email(message="Tipo de E-mail invalido")
	@Column(name="email")
	private String email;
	
	@NotBlank(message="CEP é obrigatório")
	@Size(min=8,message="Verificar número")
	@Column(name="cep")
	private String cep;
	
	@NotBlank(message="Rua é obrigatório")
	@Column(name="rua")
	private String rua;
	
	@NotBlank(message="Número é obrigatório")
	@Size(min=1, max=8, message="Verificar quantidade de número digitados")
	@Column(name="numero")
	private String numero;
	
	@NotBlank(message="Complemento é obrigatório")
	@Column(name="complemento")
	private String complemento;
	
	@NotBlank(message="Bairro é obrigatório")
	@Column(name="bairro")
	private String bairro;
	
	@NotBlank(message="Cidade é obrigatório")
	@Column(name="cidade")
	private String cidade;
	
	@NotBlank(message="Estado é obrigatório")
	@Column(name="estado")
	private String estado;
	
	public Usuario() {
		
	}
	
	public Usuario(String nome, String cpf, String email, String cep, String rua, String numero, String complemento, String bairro,
			String cidade, String estado) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
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
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}
	
	
	
	

}
