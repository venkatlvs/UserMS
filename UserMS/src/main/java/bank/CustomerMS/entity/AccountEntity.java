package bank.CustomerMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class AccountEntity {
	@Id
	@Column(name = "CUSTOMER_ID", nullable = false)
	private Long customerId;
	@Column(name = "IFSC_CODE", nullable = false)
	private String ifscCode;
	@Column(name = "BRANCH", nullable = false)
	private String branch;
	@Column(name = "BRANCH_ADDRESS", nullable = false)
	private String branchAddress;

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}



	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

}
