package co.nz.codingdojo.tweeter.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import co.nz.codingdojo.tweeter.domain.TweeterUser;
import co.nz.codingdojo.tweeter.services.InvalidLoginException;
import co.nz.codingdojo.tweeter.services.LoginService;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

public class LoginServletTest {
	
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;		
	private LoginServlet loginServlet;		
    private TweeterUser scottTiger;

	
	@Before 
	public void setupRequestResponseObjects() throws Exception {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();			
		loginServlet = new LoginServlet();		
		LoginService loginService = mock(LoginService.class);
		loginServlet.setLoginService(loginService);
        scottTiger = new TweeterUser("scott","tiger");

		when(loginService.login("scott", "tiger")).thenReturn(scottTiger);

		when(loginService.login("invaliduser", "invalidpassword"))
			.thenThrow(new InvalidLoginException());
	}
	
	@Test
	public void servletShouldForwardToHomePageIfUsernameAndPasswordOK() throws Exception {
				
        request.setParameter("username", "scott");
		request.setParameter("password", "tiger");
		
		loginServlet.doPost(request, response);
		
		assertThat(response.getRedirectedUrl(), is("/tweeter-web"));		
	}
	
	@Test
	public void servletShouldStoreUserInSessionIfUsernameAndPasswordOK() throws Exception {
				
		request.setParameter("username", "scott");
		request.setParameter("password", "tiger");
		
		loginServlet.doPost(request, response);
        TweeterUser storedUser = (TweeterUser) request.getSession().getAttribute("tweeterUser");
        assertThat(storedUser, is(scottTiger));
	}

	
	@Test
	public void servletShouldForwardToHomePageIfUsernameAndPasswordIncorrect() throws Exception {
				
		request.setParameter("username", "invalidusername");
		request.setParameter("password", "invalidpassword");
		
		loginServlet.doPost(request, response);
		
		assertThat(response.getRedirectedUrl(), is("/tweeter-web"));		
	}

	@Test
	public void servletShouldNotStoreUserInSessionIfUsernameAndPasswordWrong() throws Exception {
				
		request.setParameter("username", "invalidusername");
		request.setParameter("password", "invalidpassword");
				
		loginServlet.doPost(request, response);
		TweeterUser user = (TweeterUser) request.getSession().getAttribute("tweeterUser");
		assertThat(user, is(nullValue()));
	}

	
	@Test
	public void servletShouldShowErrorMessageIfUsernameWrong() throws Exception {
				
		request.setParameter("username", "invaliduser");
		request.setParameter("password", "invalidpassword");
		
		loginServlet.doPost(request, response);
		
		assertThat((String)request.getAttribute("errorMessage"), is("Invalid username or password"));	
	}
}
