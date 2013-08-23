package pl.bb.practicalUnitTesting;

import java.util.ArrayList;
import java.util.List;

import pl.bb.practicalUnitTesting.userService.User;

public class UserList {
	private final List<User> users = new ArrayList<User>();

	public List<User> getUsers() {
		return users;
	}

	public void addUser(User user) {
		users.add(user);
	}
}
