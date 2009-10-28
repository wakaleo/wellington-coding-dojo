package co.nz.codingdojo.tweeter.domain;

public class TweeterUser {

	private String username;
	private String password;
	
	public TweeterUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
