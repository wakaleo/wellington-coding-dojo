package co.nz.codingdojo.tweeter.services;

import com.google.inject.ImplementedBy;
import co.nz.codingdojo.tweeter.domain.TweeterUser;

@ImplementedBy(InMemoryUserDirectory.class)
public interface UserDirectory {

	TweeterUser findUserByUsername(String username);

	void addUser(String username, String password);
}
