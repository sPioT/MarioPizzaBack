package com.idformation.marioPizza.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.idformation.marioPizza.core.dto.OrderDTO;
import com.idformation.marioPizza.core.dto.OrderLineDTO;
import com.idformation.marioPizza.core.mapper.OrderLineMapper;
import com.idformation.marioPizza.core.mapper.OrderMapper;
import com.idformation.marioPizza.core.models.Order;
import com.idformation.marioPizza.core.models.OrderLine;

public class OrderTest {

	@Test
	void orderMapperConstructor() {
		// given

		// when

		// then
		Assert.isInstanceOf(OrderMapper.class, new OrderMapper());
	}

	@Test
	void orderLineMapperConstructor() {
		// given

		// when

		// then
		Assert.isInstanceOf(OrderLineMapper.class, new OrderLineMapper());
	}

	@Test
	void nullToEntity() {
		// given

		// when

		Order dto = OrderMapper.toEntity(null);

		// then
		Assert.isNull(dto, "orderLine appears");

	}

	@Test
	void nullToOrderLine() {
		// given

		// when

		OrderLine dto = OrderLineMapper.toEntity(null);

		// then
		Assert.isNull(dto, "order appears");
	}

	@Test
	void nullLineToOrder() {
		// given
		OrderDTO dto = new OrderDTO();
		// when

		Order order = OrderMapper.toEntity(dto);

		// then
		Assert.isNull(order.getLines(), "order lines appear");
	}

	@Test
	void orderLineDtosToEntity() {
		// given
		List<OrderLineDTO> dtos = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			OrderLineDTO dto = new OrderLineDTO();
			dto.setPizzaId((long) i);
			dto.setQuantity((short) i);
			dtos.add(dto);
		}

		OrderDTO dto = new OrderDTO();
		dto.setLines(dtos);

		// when

		Order entity = OrderMapper.toEntity(dto);

		// then
		Assert.isTrue(entity.getLines().size() == dtos.size(), "lines count has changed");

	}

	@Test
	void orderLineDtoToEntity() {
		// given
		OrderLineDTO dto = new OrderLineDTO();
		dto.setPizzaId(1L);
		dto.setQuantity((short) 10);

		// when

		OrderLine entity = OrderLineMapper.toEntity(dto);

		// then
		Assert.isTrue(dto.getPizzaId().equals(entity.getPizza().getId()), "ID has changed");
		Assert.isTrue(dto.getQuantity().equals(entity.getQuantity()), "ID has changed");

	}

}
