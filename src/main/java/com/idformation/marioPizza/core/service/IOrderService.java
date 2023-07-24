package com.idformation.marioPizza.core.service;

import com.idformation.marioPizza.core.models.Order;

public interface IOrderService {

	/**
	 * Save an order and update its amount
	 * @param order an order
	 */

	Order saveOrder(Order order);

}
