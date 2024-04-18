package com.idformation.marioPizza.core.dto;

import java.util.List;

public class OrderDTO {

	/** total amount of the order. */
	private Double totalAmount;

	/** details of the order. */
	private List<OrderLineDTO> lines;

	/**
	 *
	 */
	public OrderDTO() {
		super();
	}

	/**
	 * @return the totalAmount
	 */
	public Double getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param pTotalAmount the totalAmount to set
	 */
	public void setTotalAmount(final Double pTotalAmount) {
		this.totalAmount = pTotalAmount;
	}

	/**
	 * @return the lines
	 */
	public List<OrderLineDTO> getLines() {
		return lines;
	}

	/**
	 * @param pLines the lines to set
	 */
	public void setLines(final List<OrderLineDTO> pLines) {
		this.lines = pLines;
	}

}
