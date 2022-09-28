package com.bean;

	
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue
	private int cartId;
	private String cartTotal;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@ManyToMany
	@JoinTable(name = "cart_item", joinColumns = { @JoinColumn(name = "cartId") }, inverseJoinColumns = {
			@JoinColumn(referencedColumnName = "itemId") })
	private List<Item> items;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(String cartTotal) {
		this.cartTotal = cartTotal;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
