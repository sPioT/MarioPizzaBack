package com.idformation.marioPizza.core.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_line")
public class OrderLine {

	/** a technical id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** the order. */
	@ManyToOne
	@JoinColumn(name = "ord_id", referencedColumnName = "id", nullable = false)
	private Order order;

	/** the pizza. */
	@ManyToOne
	@JoinColumn(name = "piz_id", referencedColumnName = "id", nullable = false)
	private Pizza pizza;

	/** the quantity. */
	@Column(name = "quantity")
	private Short quantity;

	/**
	 *
	 */
	public OrderLine() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @return the pizza
	 */
	public Pizza getPizza() {
		return pizza;
	}

	/**
	 * @return the quantity
	 */
	public Short getQuantity() {
		return quantity;
	}

	/**
	 * @param pId the id to set
	 */
	public void setId(final Long pId) {
		this.id = pId;
	}

	/**
	 * @param pOrder the order to set
	 */
	public void setOrder(final Order pOrder) {
		this.order = pOrder;
	}

	/**
	 * @param pPizza the pizza to set
	 */
	public void setPizza(final Pizza pPizza) {
		this.pizza = pPizza;
	}

	/**
	 * @param pQuantity the quantity to set
	 */
	public void setQuantity(final Short pQuantity) {
		this.quantity = pQuantity;
	}

}
