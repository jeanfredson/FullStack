package com.lista.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="tbl_venda")
public class Venda implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "id", sequenceName = "id_venda")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@NotNull(message = "Data não pode ser nula")
	@NotBlank(message = "Data deve ser informada")
	@Column(name = "data")
	private Calendar data;
	
	@NotNull(message = "Data não pode ser nula")
	@NotBlank(message = "Data deve ser informada")
	@NumberFormat(pattern = ".##,#00.00")
	@Column(name = "valor_total", columnDefinition = "decimal(12,2)", nullable = false)
	@Min(value = 0, message = "Verificar valor mínimo")
	@Max(value = 999999, message = "Verificar o valor máximo")
	private Double valorTotal;
	
	@NotNull(message = "Data não pode ser nula")
	@NotBlank(message = "Data deve ser informada")
	@Column(name = "parcelas", nullable = false)
	@Min(value = 0, message = "Verificar valor mínimo")
	@Max(value = 12, message = "Verificar o valor máximo")
	private Integer parcelas;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
	@JoinColumn(name = "venda_item", referencedColumnName = "id", nullable = false)
	private List<VendaItem> vendaItens = new ArrayList<>();
	
	public Venda() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Calendar getData() {
		return data;
	}


	public void setData(Calendar data) {
		this.data = data;
	}


	public Double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public Integer getParcelas() {
		return parcelas;
	}


	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
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
		Venda other = (Venda) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}
	
	

}
