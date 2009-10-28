package co.nz.codingdojo.tweeter.services;

import com.google.inject.ImplementedBy;

import co.nz.codingdojo.tweeter.domain.TweeterUser;

@ImplementedBy(LoginServiceImpl.class)
public interface LoginService {

	void setUserDirectory(UserDirectory userDirectory);

	TweeterUser login(String username, String password) throws InvalidLoginException;

}
