package co.nz.codingdojo.tweeter.web;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import co.nz.codingdojo.tweeter.domain.TweeterUser;

public class LogoutServletTest {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;		
	private LogoutServlet logoutServlet;		

	@Before 
	public void setupRequestResponseObjects() throws Exception {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();			
		logoutServlet = new LogoutServlet();		
		request.getSession().setAttribute("tweeterUser", new TweeterUser("scott","tiger"));	
	}
	
	@Test
	public void logoutGoToHomePage() throws Exception {
				
		logoutServlet.doGet(request, response);
		
		assertThat(response.getRedirectedUrl(), is("/tweeter-web"));		
	}
	
	@Test
	public void logoutShouldRemoveUserFromSession() throws Exception {
				
		logoutServlet.doGet(request, response);
		
		TweeterUser user = (TweeterUser) request.getSession().getAttribute("tweeterUser");
		assertThat(user, is(nullValue()));
	}	
}
