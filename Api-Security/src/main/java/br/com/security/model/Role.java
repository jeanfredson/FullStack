package br.com.security.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {
	
	@Id
	private String nome;

	@ManyToMany(mappedBy="roles")
	private List<Security> securiites;
	
	public Role(String name, List<Security> securiites) {
		this.nome = name;
		this.securiites = securiites;
	}

	public Role(List<Security> securiites) {
		this.securiites = securiites;
	}

	public Role(String nome) {
		this.nome = nome;
	}

	public String getName() {
		return nome;
	}

	public void setName(String name) {
		this.nome = name;
	}

	public List<Security> getSecuriites() {
		return securiites;
	}

	public void setSecuriites(List<Security> securiites) {
		this.securiites = securiites;
	}
	
	
	
	

}
