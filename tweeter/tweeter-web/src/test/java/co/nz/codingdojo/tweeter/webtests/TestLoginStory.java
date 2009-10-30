package co.nz.codingdojo.tweeter.webtests;

public class TestLoginStory extends AbstractBaseStory {

    public void testUserShouldLogInByEnteringUsername() throws Exception {
        beginAt("/");
        assertTextPresent("Sign in");
        setTextField("username", "scott");
        setTextField("password", "tiger");
        submit();
        assertTextPresent("Hi scott!");
    }

    public void testUserCanLogOffUsingLogoutButton() throws Exception {
        userLogsOn("scott", "tiger");
        clickLinkWithExactText("Logout");
        assertTextPresent("Sign in");
    }
    
    public void testWrongUser() throws Exception {
    	beginAt("/");
        assertTextPresent("Sign in");
        setTextField("username", "wrong-user");
        setTextField("password", "tiger");
        submit();
        assertTextPresent("Invalid username or password");
    }
    
    public void testWrongPassword() throws Exception {
    	beginAt("/");
        assertTextPresent("Sign in");
        setTextField("username", "scott");
        setTextField("password", "wrong-password");
        submit();
        assertTextPresent("Invalid username or password");
    }

}
