package teampractice.ssiiin;

public class Myclass {
	public String username;
	private String password;
	private int age;
	private String email;
	
	public Myclass(String username, String password, int age, String email) {
		super();
		this.username = "ssiiin";
		this.password = "12345!";
		this.age = 25;
		this.email = "gomee312@naver.com";
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Myclass [username=" + username + ", password=" + password + ", age=" + age + ", email=" + email + "]";
	}
	
	
}
