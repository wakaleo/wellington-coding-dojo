package co.nz.codingdojo.tweeter.services;

import com.google.inject.Inject;

import co.nz.codingdojo.tweeter.domain.TweeterUser;

public class LoginServiceImpl implements LoginService {

	@Inject
	private UserDirectory userDirectory;
	
	public void setUserDirectory(UserDirectory userDirectory) {
		this.userDirectory = userDirectory;
	}
	
	public UserDirectory getUserDirectory() {
		return userDirectory;
	}

	public TweeterUser login(String username, String password) throws InvalidLoginException {		
		System.out.println("User Directory = " + userDirectory);
		TweeterUser user = getUserDirectory().findUserByUsername(username);
		if ((user == null) || (!user.getPassword().equals(password))) {
			throw new InvalidLoginException();
		}
		return user;
	}
}
