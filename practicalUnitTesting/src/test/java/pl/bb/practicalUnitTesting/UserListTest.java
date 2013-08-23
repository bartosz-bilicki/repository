package pl.bb.practicalUnitTesting;

import static org.fest.assertions.api.Assertions.*;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pl.bb.practicalUnitTesting.userService.User;

@Test
public class UserListTest {

	private UserList userListSut;

	@Mock
	private User user;

	@BeforeMethod
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		userListSut = new UserList();
	}

	public void shouldConstructedListBeEmpty() {
		assertThat(userListSut.getUsers()).isEmpty();
	}

	public void shouldHaveOneUserAfterOneIsAdded() {
		// when
		userListSut.addUser(user);

		// then
		assertThat(userListSut.getUsers()).hasSize(1).contains(user);
	}
}
