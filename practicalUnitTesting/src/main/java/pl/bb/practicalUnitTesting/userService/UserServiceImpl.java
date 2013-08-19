package pl.bb.practicalUnitTesting.userService;

public class UserServiceImpl {
	private final UserDAO userDAO;
	private final SecurityService securityService;

	public UserServiceImpl(UserDAO userDAO, SecurityService securityService) {
		this.userDAO = userDAO;
		this.securityService = securityService;
	}

	public void assignPassword(User user) throws Exception {
		String passwordMd5 = securityService.md5(user.getPassword());
		user.setPassword(passwordMd5);
		userDAO.updateUser(user);
	}
}
