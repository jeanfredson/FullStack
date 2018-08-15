package br.com.security.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Task {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty(message="Campo Obrigatório 'DATA' ")
	private String date;
	
	@NotEmpty(message="Campo Obrigatório 'START TIME' ")
	private String startTime;
	
	@NotEmpty(message="Campo Obrigatório 'STOP TIME' ")
	private String stopTime;
	
	@NotEmpty(message="Campo Obrigatório 'DESCRIÇÃO' ")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="SECURITY_EMAIL")
	@NotEmpty(message="Campo Obrigatório 'SECURITYS' ")
	private Security security;
	
	public Task() {
		// TODO Auto-generated constructor stub
	}

	public Task(String date, String startTime, String stopTime, String description, Security security) {
		
		this.date = date;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.description = description;
		this.security = security;
	}

	public Task(String date, String startTime, String stopTime, String description) {
		
		this.date = date;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getStopTime() {
		return stopTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}
	
	
	
	

}
