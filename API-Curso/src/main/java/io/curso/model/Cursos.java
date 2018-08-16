package io.curso.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="tabela_cursos")
public class Cursos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message="Valir Obrigatório")
	@Size(min=2, max=120, message="Verificar quantidade de caracteres")
	private String nome;
	
	@NotBlank(message="Valir Obrigatório")
	private String universidade;
	
	@OneToMany
	private List<Aluno> alunos;
	
	
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
	public String getUniversidade() {
		return universidade;
	}
	public void setUniversidade(String universidade) {
		this.universidade = universidade;
	}
	
	public Cursos() {
		// TODO Auto-generated constructor stub
	}
	public Cursos(String nome, String universidade) {
		this.nome = nome;
		this.universidade = universidade;
	}
	
	public Cursos(Long id, String nome, String universidade) {
		this.id = id;
		this.nome = nome;
		this.universidade = universidade;
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	

}
