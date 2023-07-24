package com.idformation.marioPizza.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.idformation.marioPizza.core.models.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long>{

	@Query(nativeQuery = true, value = "SELECT SUM(quantity*price) FROM order_line ol INNER JOIN pizza p ON p.id=ol.piz_id WHERE ol.ord_id = :id")
	double computeAmount(@Param("id") Long id);

	@Query(nativeQuery = true, value = "UPDATE `order` set total_amount = (SELECT SUM(quantity*price) FROM order_line ol INNER JOIN pizza p ON p.id=ol.piz_id WHERE ol.ord_id = :id) WHERE id= :id")
	void updateAmount(@Param("id") Long id);



}
