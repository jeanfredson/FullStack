package io.curso.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Evento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	@NotEmpty(message="Campo obrigatório")
	private String nome;
	@NotEmpty(message="Campo obrigatório")
	private String local;
	@NotEmpty(message="Campo obrigatório")
	private String data;
	@NotEmpty(message="Campo obrigatório")
	private String horario;
	
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Long getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public Evento(Long id, String nome, String local, String data, String horario) {
		this.codigo = id;
		this.nome = nome;
		this.local = local;
		this.data = data;
		this.horario = horario;
	}
	public Evento() {
		
	}
	
	
	
	

}
