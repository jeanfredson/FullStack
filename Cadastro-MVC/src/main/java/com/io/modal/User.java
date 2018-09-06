package com.io.modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tbl_user")
public class User {
	
	@Id
	@SequenceGenerator(name="id", sequenceName="id_user", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
	private Long id;
	
	@NotNull(message = "Campo não pode ser nulo")
	@NotBlank(message = "Informe o seu nome")
	@Size(min = 2, max = 80, message = "Verificar quantidade mínima e maxima de caracteres")
	@Column(name = "nome", length = 80, nullable = false)
	private String nome;
	
	@NotNull(message = "Campo não pode ser nulo")
	@NotBlank(message = "Informe o seu sobre nome")
	@Size(min = 2, max = 80, message = "Verificar quantidade mínima e maxima de caracteres")
	@Column(name = "s_nome", length = 80, nullable = false)
	private String snome;
	
	@NotNull(message = "Data de Vencimento é obrigatório")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	public User() {
		// TODO Auto-generated constructor stub
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

	public String getSnome() {
		return snome;
	}

	public void setSnome(String snome) {
		this.snome = snome;
	}


	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
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
		User other = (User) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}
	
	

}
