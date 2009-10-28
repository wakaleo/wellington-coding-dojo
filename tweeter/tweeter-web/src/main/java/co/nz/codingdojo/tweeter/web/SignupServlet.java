package co.nz.codingdojo.tweeter.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nz.codingdojo.tweeter.domain.TweeterUser;
import co.nz.codingdojo.tweeter.services.SignupService;
import co.nz.codingdojo.tweeter.web.guice.AbstractInjectableServlet;

import com.google.inject.Inject;

public class SignupServlet extends AbstractInjectableServlet {

	private static final long serialVersionUID = 1L;
	
	private SignupService signupService;

	@Inject
	public void setSignupService(SignupService signupService) {
		this.signupService = signupService;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		TweeterUser user = signupService.signup(req.getParameter("username"), 
				                                req.getParameter("password"));
		req.getSession().setAttribute("tweeterUser", user);
		resp.sendRedirect(resp.encodeRedirectURL("/tweeter-web") );
	}
}
