package in.ineuron.service;

import in.ineuron.dao.ILoginDao;

public class LoginServiceImpl implements ILoginService {

	private ILoginDao dao;

	public LoginServiceImpl() {
		System.out.println("LoginServiceImpl.LoginServiceImpl() Zero Arg Constructor");
	}
	
	public LoginServiceImpl(ILoginDao dao) {
		System.out.println("LoginServiceImpl.LoginServiceImpl() Arg Constructor");
		this.dao = dao;
	}

	@Override
	public boolean login(String username, String password) {
		if (username.equals("") || password.equals(""))
			throw new IllegalArgumentException("Empty Credentials");

		int id = dao.authenticate(username, password);
		if (id == 0) {
			return false;
		} else
			return true;
	}

	@Override
	public String registerUser(String username, String role) {
		if (!username.equalsIgnoreCase("") && !role.equalsIgnoreCase("") && !role.equalsIgnoreCase("visitor")) {
			int id = dao.addUser(username, role);
			return "User added with id: " + id;
		} else
			return "User not added";
	}

}
