package com.idformation.marioPizza.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.idformation.marioPizza.core.dto.PizzaDTO;
import com.idformation.marioPizza.core.mapper.PizzaMapper;
import com.idformation.marioPizza.core.models.Pizza;

class PizzaTest {

	@Test
	void pizzaMapperConstructor() {
		// given

		// when

		// then
		Assert.isInstanceOf(PizzaMapper.class, new PizzaMapper());
	}

	@Test
	void nullsToDtos() {
		// given
		List<Pizza> pizzas = null;

		// when

		List<PizzaDTO> dtos = PizzaMapper.toDTOs(pizzas);

		// then
		Assert.isTrue(dtos.size() == 0, "pizzas appeared");

	}

	@Test
	void nullToDto() {
		// given
		Pizza pizza = null;

		// when

		PizzaDTO dto = PizzaMapper.toDTO(pizza);

		// then
		Assert.isNull(dto, "pizza appeared");

	}

	@Test
	void pizzasToDtos() {
		// given
		List<Pizza> pizzas = new ArrayList<>();

		for (long i = 0; i < 10; i++) {
			Pizza pizza = new Pizza();
			pizza.setId(i);
			pizza.setDescription("ceci est la pizza " + i);
			pizza.setImage("une joile photo" + 1);
			pizza.setName("la pizza miam" + 1);
			pizza.setPrice(10.0d + 1);
			pizzas.add(pizza);
		}

		// when

		List<PizzaDTO> dtos = PizzaMapper.toDTOs(pizzas);

		// then
		for (int i = 0; i < 10; i++) {
			Assert.isTrue(pizzas.get(i).getId().equals(dtos.get(i).getId()), "Id has changed");
			Assert.isTrue(pizzas.get(i).getDescription().equals(dtos.get(i).getDescription()),
					"Description has changed");
			Assert.isTrue(pizzas.get(i).getImage().equals(dtos.get(i).getImage()), "Image has changed");
			Assert.isTrue(pizzas.get(i).getName().equals(dtos.get(i).getName()), "Name has changed");
			Assert.isTrue(pizzas.get(i).getPrice().equals(dtos.get(i).getPrice()), "Price has changed");
		}
	}

	@Test
	void pizzaToDto() {
		// given
		Pizza pizza = new Pizza();
		pizza.setId(1L);
		pizza.setDescription("ceci est une pizza");
		pizza.setImage("une joile photo");
		pizza.setName("la pizza miam");
		pizza.setPrice(10.0d);

		// when

		PizzaDTO dto = PizzaMapper.toDTO(pizza);

		// then
		Assert.isTrue(pizza.getId().equals(dto.getId()), "Id has changed");
		Assert.isTrue(pizza.getDescription().equals(dto.getDescription()), "Description has changed");
		Assert.isTrue(pizza.getImage().equals(dto.getImage()), "Image has changed");
		Assert.isTrue(pizza.getName().equals(dto.getName()), "Name has changed");
		Assert.isTrue(pizza.getPrice().equals(dto.getPrice()), "Price has changed");
	}

}
