package co.nz.codingdojo.tweeter.spikes.guice;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import co.nz.codingdojo.tweeter.services.InMemoryUserDirectory;
import co.nz.codingdojo.tweeter.services.LoginService;
import co.nz.codingdojo.tweeter.services.LoginServiceImpl;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceDITest {

	@Test
	public void obtainingALoginServiceInstance() {
	    Injector injector = Guice.createInjector();
	    LoginService loginService = injector.getInstance(LoginService.class);
	    assertThat(loginService,not(nullValue()));
	    assertThat(loginService, instanceOf(LoginServiceImpl.class));
	}
	
	@Test
	public void loginServiceInstanceShouldHaveAUserDirectory() {
	    Injector injector = Guice.createInjector();
	    LoginService loginService = injector.getInstance(LoginService.class);
	    assertThat(loginService,not(nullValue()));
	    LoginServiceImpl impl = (LoginServiceImpl) loginService;
	    assertThat(impl.getUserDirectory(),not(nullValue()));
	    assertThat(impl.getUserDirectory(), instanceOf(InMemoryUserDirectory.class));
	}
	
}
