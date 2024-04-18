package com.idformation.marioPizza.core.mapper;

import com.idformation.marioPizza.core.dto.OrderLineDTO;
import com.idformation.marioPizza.core.models.OrderLine;
import com.idformation.marioPizza.core.models.Pizza;

public class OrderLineMapper {

	/**
	 * Turn an OrderLineDTO into an OrderLine.
	 *
	 * @param dto an OrderLineDTO
	 * @return an OrderLine
	 */
	public static OrderLine toEntity(final OrderLineDTO dto) {
		OrderLine line = null;

		if (dto != null) {
			line = new OrderLine();
			line.setPizza(new Pizza(dto.getPizzaId()));
			line.setQuantity(dto.getQuantity());
		}

		return line;
	}

}
