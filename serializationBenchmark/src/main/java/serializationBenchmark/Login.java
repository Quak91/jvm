package serializationBenchmark;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	public Login() {

	}
	
	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {

		return username;

	}

	public void setUsername(String username) {

		this.username = username;

	}

	public String getPassword() {

		return password;

	}

	public void setPassword(String password) {

		this.password = password;

	}
	
	public String toString() {
		return this.username + "---" + this.password;
	}
	
}
