package co.nz.codingdojo.tweeter.services;

import org.junit.Test;

import co.nz.codingdojo.tweeter.domain.TweeterUser;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

public class SignupServiceTest {

	@Test
	public void signupWithValidUserAddsUser() {
		SignupService signupService = new SignupServiceImpl();
		
		UserDirectory mockUserDirectory = mock(UserDirectory.class);
		signupService.setUserDirectory(mockUserDirectory);
		when(mockUserDirectory.findUserByUsername("validuser")).thenReturn(new TweeterUser("validuser","validpassword"));
		
		TweeterUser user = signupService.signup("validuser","validpassword");
		assertThat(user, not(nullValue()));
		assertThat(user.getUsername(), is("validuser"));
		assertThat(user.getPassword(), is("validpassword"));
		verify(mockUserDirectory, atLeastOnce()).addUser("validuser","validpassword");
	}
}
