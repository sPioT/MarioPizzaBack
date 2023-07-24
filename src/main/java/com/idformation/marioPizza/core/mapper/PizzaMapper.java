package com.idformation.marioPizza.core.mapper;

import java.util.ArrayList;
import java.util.List;

import com.idformation.marioPizza.core.dto.PizzaDTO;
import com.idformation.marioPizza.core.models.Pizza;


public class PizzaMapper {

	/**
	 * turn a Pizza into a PizzaDTO
	 * @param pizza the Pizza
	 * @return pizza turned into a PizzaDTO
	 */
	public static PizzaDTO toDTO(Pizza pizza) {
		PizzaDTO dto = null;

		if(pizza != null){
			dto=new PizzaDTO();
			dto.setId(pizza.getId());
			dto.setDescription(pizza.getDescription());
			dto.setName(pizza.getName());
			dto.setPrice(pizza.getPrice());
			dto.setImage(pizza.getImage());
		}

		return dto;
	}

	/**
	 * turn a list of Pizzas into a list of PizzaDTO
	 * @param pizzas a list of Pizza
	 * @return pizzas turned into a list of PizzaDTO
	 */

	public static List<PizzaDTO> toDTOs(List<Pizza> pizzas) {
		List<PizzaDTO> dtos = new ArrayList<>();

		if(pizzas!=null) {
			for(Pizza  pizza: pizzas) {
				dtos.add(toDTO(pizza));
			}
		}

		return dtos;

	}

}
