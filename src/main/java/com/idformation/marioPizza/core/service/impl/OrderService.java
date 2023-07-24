package com.idformation.marioPizza.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idformation.marioPizza.core.models.Order;
import com.idformation.marioPizza.core.repository.IOrderRepository;
import com.idformation.marioPizza.core.service.IOrderService;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private IOrderRepository orderRepository;

	@Override
	public Order saveOrder(Order order) {
		Order saved = orderRepository.save(order);

		saved.setTotalAmount(orderRepository.computeAmount(saved.getId()));

		orderRepository.save(saved);

		return saved;
	}

}
