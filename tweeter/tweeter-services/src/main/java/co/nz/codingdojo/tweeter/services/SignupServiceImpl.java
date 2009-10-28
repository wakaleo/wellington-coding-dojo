package co.nz.codingdojo.tweeter.services;

import com.google.inject.Inject;

import co.nz.codingdojo.tweeter.domain.TweeterUser;

public class SignupServiceImpl implements SignupService {

	@Inject
	private UserDirectory userDirectory;
	
	public void setUserDirectory(UserDirectory userDirectory) {
		this.userDirectory = userDirectory;
	}
	
	public UserDirectory getUserDirectory() {
		return userDirectory;
	}

	public TweeterUser signup(String username, String password) {
		userDirectory.addUser(username, password);
		return userDirectory.findUserByUsername(username);
	}

	
}
