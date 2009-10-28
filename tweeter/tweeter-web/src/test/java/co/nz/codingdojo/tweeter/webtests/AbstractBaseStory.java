package co.nz.codingdojo.tweeter.webtests;

import net.sourceforge.jwebunit.junit.WebTestCase;

public abstract class AbstractBaseStory extends  WebTestCase {

	public void setUp() {
		setBaseUrl("http://localhost:8080/tweeter-web");
	}

    public void userLogsOn(String username, String password) throws Exception {
		beginAt("/"); 
		assertTextPresent("Sign in");
		setTextField("username", username);
		setTextField("password", password);
		submit();
		assertTextPresent("Hi " + username + "!");
    }   
    
    public void userLogsOff() {
        clickLinkWithExactText("Logout");
		assertTextPresent("Sign in");
    }	
}
