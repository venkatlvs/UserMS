package bank.CustomerMS.entity;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOGS")
public class CustomerHistory {
	@Id
	@Column(name = "CUSTOMER_ID", nullable = false)
	private Integer customerId;
	
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@Column(name="LOG_TIME",nullable = false)
	private LocalTime loginTime;
	
//	@Column(name = "LOGGED_DATE", nullable = false)
//	private Timestamp loggedDate;
//	@Column(name = "LOGGED_DATE_ACCOUNT", nullable = false)
//	@Id
//	private String pkLoggedDate;



	public Integer getCustomerId() {
		return customerId;
	}



	public LocalTime getLoginTime() {
		return loginTime;
	}



	public void setLoginTime(LocalTime loginTime) {
		this.loginTime = loginTime;
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
