package co.nz.codingdojo.tweeter.services;

import com.google.inject.ImplementedBy;

import co.nz.codingdojo.tweeter.domain.TweeterUser;

@ImplementedBy(SignupServiceImpl.class)
public interface SignupService {

	void setUserDirectory(UserDirectory userDirectory);

	TweeterUser signup(String username, String password);

}
