
package model.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Transactional
@Entity
@Table(name = "tb_itenspedido")
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codItemPedido;

	private Integer quantidade;

	@ManyToOne
	@JoinColumn(name = "pedido")
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "item")
	private Item item;

	public ItemPedido() {
	}

	public ItemPedido(Integer codItemPedido, Integer quantidade, Pedido pedido, Item item) {
		super();
		this.codItemPedido = codItemPedido;
		this.quantidade = quantidade;
		this.pedido = pedido;
		this.item = item;
	}

	public Integer getCodItemPedido() {
		return codItemPedido;
	}

	public void setCodItemPedido(Integer codItemPedido) {
		this.codItemPedido = codItemPedido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	// @XmlTransient
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codItemPedido == null) ? 0 : codItemPedido.hashCode());
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
		ItemPedido other = (ItemPedido) obj;
		if (codItemPedido == null) {
			if (other.codItemPedido != null)
				return false;
		} else if (!codItemPedido.equals(other.codItemPedido))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemPedido [codItemPedido=" + codItemPedido + ", quantidade=" + quantidade + "]";
	}

}
