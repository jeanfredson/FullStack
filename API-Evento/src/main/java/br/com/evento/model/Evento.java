package br.com.evento.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="tabela_evento")
public class Evento implements Serializable{
	
	private static final Long SerializableUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty(message="Nome é obrigatório")
	@Size(min=2, max=120, message="Verificar quantidade de caracteres")
	private String nome;
	
	@NotEmpty(message="Local é obrigatório")
	@Size(min=2, max=160, message="Verificar quantidade de caracteres")
	private String local;
	
	@NotEmpty(message="Data é obrigatório")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@NotEmpty(message="Nome é obrigatório")
	private String horario;
	
	@OneToMany
	private List<Convidado> convidados;
	
	public Evento() {
		// TODO Auto-generated constructor stub
	}
	public Evento(String nome, String local, Date data, String horario) {
	
		this.nome = nome;
		this.local = local;
		this.data = data;
		this.horario = horario;
	}  
	public Evento(Long id, String nome, String local, Date data, String horario) {
		super();
		this.id = id;
		this.nome = nome;
		this.local = local;
		this.data = data;
		this.horario = horario;
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
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public List<Convidado> getConvidados() {
		return convidados;
	}
	public void setConvidados(List<Convidado> convidados) {
		this.convidados = convidados;
	}
	
	
	

}
