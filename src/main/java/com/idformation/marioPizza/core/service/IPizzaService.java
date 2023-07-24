package com.idformation.marioPizza.core.service;

import java.util.List;

import com.idformation.marioPizza.core.models.Pizza;

public interface IPizzaService {

	/**
	 *
	 * @return all known pizzas
	 */
	List<Pizza> getAll();

}
