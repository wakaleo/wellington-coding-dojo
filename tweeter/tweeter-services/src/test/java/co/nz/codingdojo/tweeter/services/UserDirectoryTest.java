package co.nz.codingdojo.tweeter.services;

import org.junit.Test;

import co.nz.codingdojo.tweeter.domain.TweeterUser;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserDirectoryTest {

	@Test
	public void shouldFindExistingUsersInDirectory() {
		InMemoryUserDirectory directory = new InMemoryUserDirectory();
		directory.addUser("scott", "tiger");
		
		TweeterUser loadedUser = directory.findUserByUsername("scott");
		assertThat(loadedUser, not(nullValue()));
		assertThat(loadedUser.getUsername(), is("scott"));
		assertThat(loadedUser.getPassword(), is("tiger"));
	}

	@Test
	public void shouldBeAbleToAddAUserToDirectory() {
		InMemoryUserDirectory directory = new InMemoryUserDirectory();
		directory.addUser("jesse", "james");
		
		TweeterUser loadedUser = directory.findUserByUsername("jesse");
		assertThat(loadedUser, not(nullValue()));
		assertThat(loadedUser.getUsername(), is("jesse"));
		assertThat(loadedUser.getPassword(), is("james"));
	}

	
	@Test
	public void shouldReturnNullIfUserNotInDirectory() {
		InMemoryUserDirectory directory = new InMemoryUserDirectory();
		directory.addUser("scott", "tiger");
		
		TweeterUser loadedUser = directory.findUserByUsername("dave");
		assertThat(loadedUser, is(nullValue()));
	}

}
