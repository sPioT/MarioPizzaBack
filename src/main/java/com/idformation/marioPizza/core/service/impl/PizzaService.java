package com.idformation.marioPizza.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idformation.marioPizza.core.models.Pizza;
import com.idformation.marioPizza.core.repository.IPizzaRepository;
import com.idformation.marioPizza.core.service.IPizzaService;

@Service
public final class PizzaService implements IPizzaService {

	/**
	 * the repository for the pizzas.
	 */
	@Autowired
	private IPizzaRepository pizzaRepo;

	@Override
	public List<Pizza> getAll() {
		return pizzaRepo.findAll();
	}

}
