package pl.bb.practicalUnitTesting.userService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.testng.annotations.Test;

@Test
public class UserServiceImplTest {

	public void shouldUserPasswordBeMD5() throws Exception {
		// given
		UserDAO userDAO = mock(UserDAO.class);
		SecurityService securityService = mock(SecurityService.class);

		UserServiceImpl userService = new UserServiceImpl(userDAO, securityService);
		User user = mock(User.class);

		// when
		userService.assignPassword(user);

		// then
		verify(user).setPassword(user.getPassword());
		verify(userDAO).updateUser(user);
		verify(securityService).md5(user.getPassword());
	}
}
