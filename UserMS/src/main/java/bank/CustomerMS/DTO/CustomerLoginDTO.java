package bank.CustomerMS.DTO;

public class CustomerLoginDTO {

	String password;
	String email;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CustomerLoginDTO() {
		super();
	}

	@Override
	public String toString() {
		return "UserLoginDTO [password=" + password + ", email=" + email + "]";
	}

}
