package com.idformation.marioPizza.core.dto;

public class OrderDTO {
	private Long pizzaId;
	private Short quantity;
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
	 * @param pizzaId the pizzaId to set
	 */
	public void setPizzaId(Long pizzaId) {
		this.pizzaId = pizzaId;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Short quantity) {
		this.quantity = quantity;
	}

}
