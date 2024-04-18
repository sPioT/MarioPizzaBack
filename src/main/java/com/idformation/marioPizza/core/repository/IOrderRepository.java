package com.idformation.marioPizza.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idformation.marioPizza.core.models.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {

}
