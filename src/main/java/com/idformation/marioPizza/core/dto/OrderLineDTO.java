package com.idformation.marioPizza.core.dto;

public class OrderLineDTO {

	/** the id of a pizza. */
	private Long pizzaId;

	/** the quantity ordered. */
	private Short quantity;

	/**
	 *
	 */
	public OrderLineDTO() {
		super();
	}

	/**
	 * @return the pizzaId
	 */
	public Long getPizzaId() {
		return pizzaId;
	}

	/**
	 * @return the quantity
	 */
	public Short getQuantity() {
		return quantity;
	}

	/**
	 * @param pPizzaId the pizzaId to set
	 */
	public void setPizzaId(final Long pPizzaId) {
		this.pizzaId = pPizzaId;
	}

	/**
	 * @param pQuantity the quantity to set
	 */
	public void setQuantity(final Short pQuantity) {
		this.quantity = pQuantity;
	}

}
