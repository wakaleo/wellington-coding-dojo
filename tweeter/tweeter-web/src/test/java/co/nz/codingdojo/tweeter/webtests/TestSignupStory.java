package co.nz.codingdojo.tweeter.webtests;

public class TestSignupStory extends AbstractBaseStory {

    public void testUserSignupShouldAddNewUser() throws Exception {
        beginAt("/signup.jsp");
        assertTextPresent("Sign up");
        setTextField("username", "jacko");
        setTextField("password", "tiger");
        submit();
        assertTextPresent("Hi jacko!");
    }
}
