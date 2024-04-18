package com.idformation.marioPizza.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idformation.marioPizza.core.dto.OrderDTO;
import com.idformation.marioPizza.core.dto.PizzaDTO;
import com.idformation.marioPizza.core.mapper.OrderMapper;
import com.idformation.marioPizza.core.mapper.PizzaMapper;
import com.idformation.marioPizza.core.models.Order;
import com.idformation.marioPizza.core.service.IOrderService;
import com.idformation.marioPizza.core.service.IPizzaService;
import com.idformation.marioPizza.security.jwt.JwtAuthenticationFilter;
import com.idformation.marioPizza.security.jwt.JwtProvider;
import com.idformation.marioPizza.security.models.User;
import com.idformation.marioPizza.security.service.impl.UserDetailsServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

	/** the service for the pizza. */
	@Autowired
	private IPizzaService pizzaService;

	/** the service for the order. */
	@Autowired
	private IOrderService orderService;

	/** the service for the user. */
	@Autowired
	private UserDetailsServiceImpl userService;

	/** the jwt provider. */
	@Autowired
	private JwtProvider jwtProvider;

	/** the JwtAuthenticationFiltera. */
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	/**
	 * Entry Point for getting all available Pizzas.
	 *
	 * @return a list of pizzas
	 */
	@GetMapping("/")
	List<PizzaDTO> getAll() {
		return PizzaMapper.toDTOs(pizzaService.getAll());
	}

	/**
	 * Entry point for saving an order.
	 *
	 * @param orderDto the dto containing the datas for the order
	 * @param request  the request received
	 */
	@PostMapping("/")
	void saveOrder(@RequestBody final OrderDTO orderDto, final HttpServletRequest request) {

		// 1. identify the user from the jwt
		User user = userService.loadUserDetails(
				jwtProvider.getUserUsernameFromJWT(jwtAuthenticationFilter.getJwtFromRequest(request)));

		// 2. create an order from the requestbody
		Order order = OrderMapper.toEntity(orderDto);
		order.setUser(user);

		// 3. save the order
		orderService.saveOrder(order);

	}

}
