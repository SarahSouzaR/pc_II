package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="venda")
public class Venda implements Serializable{
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_venda;
	
	@ManyToOne 
	@JoinColumn(name="id")
	private Cliente cliente;
	//@Column
	//private int id_cliente;
	
	@Column
	private String data;
	
	@Column
	private double vlr_total;
	
	@Column
	private double desconto;
	
	@Column
	private double vlr_pago;

	public int getId_venda() {
		return id_venda;
	}

	public void setId_venda(int id_venda) {
		this.id_venda = id_venda;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getVlr_total() {
		return vlr_total;
	}

	public void setVlr_total(double vlr_total) {
		this.vlr_total = vlr_total;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getVlr_pago() {
		return vlr_pago;
	}

	public void setVlr_pago(double vlr_pago) {
		this.vlr_pago = vlr_pago;
	}
}
