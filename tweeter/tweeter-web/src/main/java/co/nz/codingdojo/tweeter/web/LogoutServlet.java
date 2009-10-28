package co.nz.codingdojo.tweeter.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nz.codingdojo.tweeter.web.guice.AbstractInjectableServlet;

/**
 * Servlet implementation class LoginServlet
 */
public class LogoutServlet extends AbstractInjectableServlet {
	private static final long serialVersionUID = 1L;

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("tweeterUser");
	    response.sendRedirect( response.encodeRedirectURL("/tweeter-web") );
	}

}
