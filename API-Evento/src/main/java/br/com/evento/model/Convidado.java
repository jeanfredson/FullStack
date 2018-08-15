package br.com.evento.model;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="tabela_convidados")
public class Convidado {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String rg;
	@NotEmpty(message="Nome Obrigatório")
	@Size(min=2, max=120, message="Verificar quantidade de caracteres")
	private String convidado;
	
	@ManyToOne
	private Evento evento;

	public String getConvidado() {
		return convidado;
	}

	public void setConvidado(String convidado) {
		this.convidado = convidado;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	

	

	
	
	
	
}
