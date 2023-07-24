package marioPizza;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.idformation.marioPizza.core.dto.OrderDTO;
import com.idformation.marioPizza.core.mapper.OrderLineMapper;
import com.idformation.marioPizza.core.mapper.OrderMapper;
import com.idformation.marioPizza.core.models.Order;
import com.idformation.marioPizza.core.models.OrderLine;

public class OrderTest {

	@Test
	void nullToEntity() {
		//given

		//when

		Order dto =OrderMapper.toEntity(null);

		//then
		Assert.isNull(dto, "orderLine appears");

	}

	@Test
	void nullToOrderLine() {
		//given

		//when

		OrderLine dto =OrderLineMapper.toEntity(null);

		//then
		Assert.isNull(dto, "order appears");
	}

	@Test
	void orderLineDtosToEntity() {
		//given
		List<OrderDTO> dtos=new ArrayList<>();
		for (int i=0;i<10;i++) {
			OrderDTO dto = new OrderDTO();
			dto.setPizzaId((long) i);
			dto.setQuantity((short) i);
			dtos.add(dto);
		}

		//when

		Order entity =OrderMapper.toEntity(dtos);

		//then
		Assert.isTrue(entity.getLines().size()==dtos.size(),"lines count has changed");


	}

	@Test
	void orderLineDtoToEntity() {
		//given
		OrderDTO dto = new OrderDTO();
		dto.setPizzaId(1l);
		dto.setQuantity((short) 10);

		//when

		OrderLine entity =OrderLineMapper.toEntity(dto);

		//then
		Assert.isTrue(dto.getPizzaId().equals(entity.getPizza().getId()), "ID has changed");
		Assert.isTrue(dto.getQuantity().equals(entity.getQuantity()), "ID has changed");

	}

}
