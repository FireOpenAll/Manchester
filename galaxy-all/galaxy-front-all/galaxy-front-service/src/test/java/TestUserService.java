import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 

import com.galaxy.dal.domain.user.User;
import com.galaxy.service.user.UserService;

@ContextConfiguration(locations = { "/spring/dao.xml",
		"/spring/datasource-config.xml" ,"/spring/service.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserService {
	@Autowired
	UserService userService;
	@Test
	public void testUser(){
		Long id=1L;
		User user=userService.getUser(id);
		Assert.assertNotNull(user);
		Assert.assertEquals("hello", user.getLoginName());
	}

}
