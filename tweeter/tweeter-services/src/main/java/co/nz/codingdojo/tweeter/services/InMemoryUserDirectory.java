package co.nz.codingdojo.tweeter.services;

import java.util.ArrayList;
import java.util.List;

import co.nz.codingdojo.tweeter.domain.TweeterUser;

public class InMemoryUserDirectory implements UserDirectory {

	private List<TweeterUser> users = new ArrayList<TweeterUser>();
	
	public InMemoryUserDirectory() {
		loadStandardUsers();
	}
	
	public TweeterUser findUserByUsername(String username) {
		TweeterUser foundUser = null;
		for(TweeterUser user : users) {
			if (user.getUsername().equals(username)) {
				foundUser = user;
				break;
			}
		}
		return foundUser;
	}

	public void addUser(String username, String password) {
		users.add(new TweeterUser(username, password));
	}
	
	private void loadStandardUsers() {
	    addUser("scott","tiger");
	    addUser("jesse","james");
	}


}
