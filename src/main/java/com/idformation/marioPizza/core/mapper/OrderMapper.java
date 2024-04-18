package com.idformation.marioPizza.core.mapper;

import java.util.Date;

import com.idformation.marioPizza.core.dto.OrderDTO;
import com.idformation.marioPizza.core.dto.OrderLineDTO;
import com.idformation.marioPizza.core.models.Order;

public class OrderMapper {

	/**
	 * Map an OrderDTO into an Order.
	 *
	 * @param order an OrderDTO
	 * @return an order
	 */
	public static Order toEntity(final OrderDTO order) {
		Order entity = null;

		if (order != null) {
			entity = new Order();
			entity.setDate(new Date());
			entity.setTotalAmount(order.getTotalAmount());

			if (order.getLines() != null) {
				for (OrderLineDTO dto : order.getLines()) {
					entity.addLine(OrderLineMapper.toEntity(dto));
				}
			}
		}

		return entity;
	}

}
