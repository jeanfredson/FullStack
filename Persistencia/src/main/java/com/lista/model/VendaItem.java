package com.lista.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "tbl_venda_item")
public class VendaItem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "id", sequenceName = "id_venda_item")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
	private Integer id;
	
	
	@NotNull(message = "quantidade não pode ser nula")
	@NotBlank(message = "quantidade deve ser informada")
	@NumberFormat(pattern = ".##,#00.00")
	@Column(name = "quantidade", columnDefinition = "decimal(12,2)", nullable = false)
	@Min(value = 0, message = "Verificar valor mínimo")
	@Max(value = 1000, message = "Verificar o valor máximo")
	private Double quantidade;
	
	@NotNull(message = "valor Unitario não pode ser nula")
	@NotBlank(message = "valor Unitario deve ser informada")
	@NumberFormat(pattern = ".##,#00.00")
	@Column(name = "valor_unitario", columnDefinition = "decimal(12,2)", nullable = false)
	@Min(value = 0, message = "Verificar valor mínimo")
	@Max(value = 999999, message = "Verificar o valor máximo")
	private Double valorUnitario;
	
	
	@NotNull(message = "valor Total não pode ser nula")
	@NotBlank(message = "valor Total deve ser informada")
	@NumberFormat(pattern = ".##,#00.00")
	@Column(name = "valor_total", columnDefinition = "decimal(12,2)", nullable = false)
	@Min(value = 0, message = "Verificar valor mínimo")
	@Max(value = 999999, message = "Verificar o valor máximo")
	private Double valorTotal;
	
	@ManyToOne
	@JoinColumn(name = "venda", referencedColumnName = "id", nullable = false)
	private Venda venda;
	
	@ManyToOne
	@JoinColumn(name="produto", referencedColumnName = "id", nullable = false)
	@NotNull(message = "Não pode ser nulo")
	@NotBlank(message="Não pode estar vazio")
	private Produto produto;
	
	public VendaItem() {
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Double getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}


	public Double getValorUnitario() {
		return valorUnitario;
	}


	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}


	public Double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		VendaItem other = (VendaItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

	
	
}
