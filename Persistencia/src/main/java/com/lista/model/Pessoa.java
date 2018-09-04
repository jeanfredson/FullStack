package com.lista.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="tbl_pessoa")
public class Pessoa {
	
	@Id
	@SequenceGenerator(name="id", sequenceName="id_pessoa", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id")
	private Integer id;
	
	@NotBlank(message="Nome tem que ser informado")
	@NotNull(message="O Nome não pode ser nulo")
	@Size(min=2, max=20, message="O Nome não pode ter mais que {max} ou menos que {min} caracteres ...")
	@Column(name="nome", nullable=false)
	private String nome;
	
	@Length(min=2, max=15, message="O telefone não pode ter mais que {max} ou menos que {min} caracteres ...")
	@NotBlank(message="telefone tem que ser informado")
	@NotNull(message="O telefone não pode ser nulo")
	@Size( min=8, max=15)
	@Column(name="telefone", nullable=false, length=15)
	private String telefone;
	
	@Email(message="Tipo de email invalido")
	@NotBlank(message="email tem que ser informado")
	@NotNull(message="O email não pode ser nulo")
	@Column(name="email", nullable=false, length=15)
	private String email;
	
	@OneToMany(mappedBy="pessoa", cascade=CascadeType.ALL, orphanRemoval = true, fetch=FetchType.LAZY)
	private List<Endereco> enderecos = new ArrayList<>();
	

}
