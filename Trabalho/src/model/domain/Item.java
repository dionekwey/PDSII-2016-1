package model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Transactional
@Entity
@Table(name="tb_itens")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codItem;
	
	private String nome;
	
	private BigDecimal preco;
	
	//@Basic(fetch = FetchType.LAZY)
	@OneToMany(mappedBy="item")
	private List<ItemPedido> itens;
	
	public Item() {
		itens = new ArrayList<>();
	}

	public Item(Integer codItem, String nome, BigDecimal d) {
		super();
		this.codItem = codItem;
		this.nome = nome;
		this.preco = d;
		itens = new ArrayList<>();
	}

	public Integer getCodItem() {
		return codItem;
	}

	public void setCodItem(Integer codItem) {
		this.codItem = codItem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
 
	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@XmlTransient
	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	@Override
	public String toString() {
		return "Item [codItem=" + codItem + ", nome=" + nome + ", preco=" + preco + "]";
	}
	
	
	
}
