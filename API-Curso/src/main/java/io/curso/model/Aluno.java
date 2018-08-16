package io.curso.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="tabela_aluno")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ra;
	
	@NotBlank(message="RG é obrigatório")
	@Size(min=9, max=12, message="Verificar preenchimento do RG")
	private String rg;

	@NotBlank(message="Nome é obrigatório")
	@Size(min=2, max=120, message="Verificar preenchimento do RG")
	private String nome;
	
	@ManyToOne
	private Cursos curso;
	
	
	public Long getRa() {
		return ra;
	}
	public void setRa(Long ra) {
		this.ra = ra;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Cursos getCurso() {
		return curso;
	}
	public void setCurso(Cursos curso) {
		this.curso = curso;
	}
	
	
	public Aluno(Long ra, String rg, String nome) {
		this.ra = ra;
		this.rg = rg;
		this.nome = nome;
	}
	public Aluno() {
		// TODO Auto-generated constructor stub
	}
	
	

}
