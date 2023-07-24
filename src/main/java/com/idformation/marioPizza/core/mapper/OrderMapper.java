package com.idformation.marioPizza.core.mapper;

import java.util.Date;
import java.util.List;

import com.idformation.marioPizza.core.dto.OrderDTO;
import com.idformation.marioPizza.core.models.Order;

public class OrderMapper {

  /**
   *
   * @param orders list of OrderDTO
   * @return an order
   */
  public static Order toEntity(final List<OrderDTO> orders) {
    Order entity = null;

    if (orders != null) {
      entity = new Order();
      entity.setDate(new Date());
      for (OrderDTO dto : orders) {
        entity.addLine(OrderLineMapper.toEntity(dto));
      }
    }

    return entity;
  }

}
