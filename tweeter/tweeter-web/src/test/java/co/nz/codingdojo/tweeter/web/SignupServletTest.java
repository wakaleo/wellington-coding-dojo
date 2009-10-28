package co.nz.codingdojo.tweeter.web;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import co.nz.codingdojo.tweeter.domain.TweeterUser;
import co.nz.codingdojo.tweeter.services.SignupService;

public class SignupServletTest {
	
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;		
	private SignupServlet signupServlet;		

	@Before 
	public void setupRequestResponseObjects() throws Exception {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();			
		signupServlet = new SignupServlet();		
		SignupService signupService = mock(SignupService.class);
		signupServlet.setSignupService(signupService);
		
		when(signupService.signup("something", "else"))
			.thenReturn(new TweeterUser("something","else"));

	}
	
	@Test
	public void signupShouldReturnToHome() throws Exception {
				
		request.setParameter("username", "something");
		request.setParameter("password", "else");
		
		signupServlet.doPost(request, response);
		
		assertThat(response.getRedirectedUrl(), is("/tweeter-web"));		
	}
	
	@Test
	public void signupShouldLogUserOn() throws Exception {
				
		request.setParameter("username", "something");
		request.setParameter("password", "else");
		
		signupServlet.doPost(request, response);
		
		TweeterUser user = (TweeterUser) request.getSession().getAttribute("tweeterUser");
		assertThat(user, not(nullValue()));
		assertThat(user.getUsername(), is("something"));
		assertThat(user.getPassword(), is("else"));
	}
	
}
