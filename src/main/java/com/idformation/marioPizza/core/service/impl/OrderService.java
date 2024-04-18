package com.idformation.marioPizza.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idformation.marioPizza.core.models.Order;
import com.idformation.marioPizza.core.repository.IOrderRepository;
import com.idformation.marioPizza.core.service.IOrderService;

@Service
public final class OrderService implements IOrderService {

	/** the repository for the orders. */
	@Autowired
	private IOrderRepository orderRepository;

	@Override
	public Order saveOrder(final Order order) {
		return orderRepository.save(order);

	}

}
