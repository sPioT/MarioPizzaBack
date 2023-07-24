package com.idformation.marioPizza.core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.idformation.marioPizza.security.service.UserDetailsServiceImpl;

@RestController
@RequestMapping("/pizza")
@CrossOrigin(origins = "http://localhost:19000", maxAge = 3600)
public class PizzaController {

	@Autowired
	private IPizzaService pizzaService;

	@Autowired
	private IOrderService orderService;

	@Autowired
	private UserDetailsServiceImpl userService;

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	@GetMapping("/")
	List<PizzaDTO> getAll() {
		return PizzaMapper.toDTOs(pizzaService.getAll());
	}

	@PostMapping("/")
	void saveOrder(@RequestBody List<OrderDTO> orders, HttpServletRequest request) {

		// 1. identify the user from the jwt
		User user = userService
				.findByUsername(jwtProvider.getUserUsernameFromJWT(jwtAuthenticationFilter.getJwtFromRequest(request)));

		// 2. create an order from the requestbody
		Order order = OrderMapper.toEntity(orders);
		order.setUser(user);

		// 3. save the order
		orderService.saveOrder(order);

	}

}
