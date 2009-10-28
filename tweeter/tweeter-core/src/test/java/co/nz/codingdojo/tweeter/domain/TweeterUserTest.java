package co.nz.codingdojo.tweeter.domain;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TweeterUserTest {

	@Test
	public void usersHaveAUsernameAndPassword() {
		TweeterUser user = new TweeterUser("scott", "tiger");
		assertThat(user.getUsername(), is("scott"));
		assertThat(user.getPassword(), is("tiger"));
	}
	
	@Test
	public void usersCanChangeTheirPasswords() {
		TweeterUser user = new TweeterUser("scott", "tiger");
		assertThat(user.getUsername(), is("scott"));
		assertThat(user.getPassword(), is("tiger"));
 
		user.setPassword("newpassword");
		assertThat(user.getUsername(), is("scott"));
		assertThat(user.getPassword(), is("newpassword"));
	}
	
}
