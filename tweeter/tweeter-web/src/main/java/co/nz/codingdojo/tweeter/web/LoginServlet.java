package co.nz.codingdojo.tweeter.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nz.codingdojo.tweeter.domain.TweeterUser;
import co.nz.codingdojo.tweeter.services.InvalidLoginException;
import co.nz.codingdojo.tweeter.services.LoginService;
import co.nz.codingdojo.tweeter.web.guice.AbstractInjectableServlet;

import com.google.inject.Inject;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends AbstractInjectableServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    private LoginService loginService;
 
    @Inject
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            TweeterUser user = loginService.login(username, password);
            request.getSession().setAttribute("tweeterUser", user);
            response.sendRedirect(response.encodeRedirectURL("/tweeter-web"));
        } catch (InvalidLoginException e) {
            request.setAttribute("errorMessage",
                                 "Invalid username or password");
            request.getRequestDispatcher("/").forward(request, response);
        }
    }
}
