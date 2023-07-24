package marioPizza;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.idformation.marioPizza.security.controller.dto.AccountRequest;
import com.idformation.marioPizza.security.controller.mapper.AccountMapper;
import com.idformation.marioPizza.security.models.User;

public class AccountTest {


	@Test
	void accountRequestToUser() {
		//given

		AccountRequest request = new AccountRequest();
		request.setAddress("adresse");
		request.setFirstname("prénom");
		request.setLastName("nom");
		request.setPassword("password");
		request.setTelephone("telephone");

		//when

		User u = AccountMapper.toEntity(request);


		//then
		Assert.notNull(u, "user is null");
		Assert.isTrue(request.getAddress().equals(u.getAddress()),"Address has changed");
		Assert.isTrue(request.getFirstname().equals(request.getFirstname()),"firstname has changed");
		Assert.isTrue(request.getLastname().equals(request.getLastname()),"Lastname has changed");
		Assert.isTrue(request.getPassword().equals(request.getPassword()),"password has changed");
		Assert.isTrue(request.getTelephone().equals(request.getTelephone()),"telephone has changed");

	}
}
