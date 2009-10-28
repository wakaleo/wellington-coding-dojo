package co.nz.codingdojo.tweeter.services;

import org.junit.Test;

import co.nz.codingdojo.tweeter.domain.TweeterUser;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

public class LoginServiceTest {

	@Test
	public void loginWithValidUsernameAndPasswordShouldReturnUser() throws InvalidLoginException {
		LoginService loginservice = new LoginServiceImpl();
		
		TweeterUser mockUser = mock(TweeterUser.class);
		when(mockUser.getUsername()).thenReturn("validuser");
		when(mockUser.getPassword()).thenReturn("validpassword");
		
		UserDirectory mockUserDirectory = mock(UserDirectory.class);
        when(mockUserDirectory.findUserByUsername("validuser")).thenReturn(mockUser);	
		
		loginservice.setUserDirectory(mockUserDirectory);
		
		TweeterUser user = loginservice.login("validuser","validpassword");
		assertThat(user, not(nullValue()));
		assertThat(user.getUsername(), is("validuser"));
	}
	
	@Test(expected=InvalidLoginException.class)
	public void loginWithUnknownUserShouldThrowInvalidLoginException() throws InvalidLoginException {
		LoginService loginservice = new LoginServiceImpl();
		
		UserDirectory mockUserDirectory = mock(UserDirectory.class);
        when(mockUserDirectory.findUserByUsername("invaliduser")).thenReturn(null);
		
		loginservice.setUserDirectory(mockUserDirectory);
		loginservice.login("invaliduser","validpassword");
	}
	
	@Test(expected=InvalidLoginException.class)
	public void loginWithInvalidUsernameAndPasswordShouldThrowInvalidLoginException() throws InvalidLoginException {
		LoginService loginservice = new LoginServiceImpl();
		
		TweeterUser mockUser = mock(TweeterUser.class);
		when(mockUser.getUsername()).thenReturn("validuser");
		when(mockUser.getPassword()).thenReturn("validpassword");
		
		UserDirectory mockUserDirectory = mock(UserDirectory.class);
        when(mockUserDirectory.findUserByUsername("validuser")).thenReturn(mockUser);	
		
		loginservice.setUserDirectory(mockUserDirectory);
		loginservice.login("validuser","invalidpassword");
	}
	
}
