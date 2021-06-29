package bank.CustomerMS.DTO;

import java.sql.Time;
import java.sql.Timestamp;

public class CustomerAuthenticateDTO {

	private Integer customerId;
	private String email;
	private Timestamp loginTime;

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
