package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nome;
	@Column
	private String cpf;
	@Column
	private String rg;
	
	@OneToMany(mappedBy="cliente",
			targetEntity=Venda.class,
			cascade=CascadeType.ALL)

	
	List<Venda> venda = new ArrayList<>();
	
	public List<Venda> getVenda(){
		return venda;
	}
	
	public void setVenda(List<Venda> venda) {
		this.venda = venda;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
	
}
