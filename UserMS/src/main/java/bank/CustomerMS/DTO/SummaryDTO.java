package bank.CustomerMS.DTO;



public class SummaryDTO {
	Integer customerId;
	SavingsDTO savings;
	CurrentDTO current;
	CreditDTO credit;
	LoandetailsDTO loan;

	public LoandetailsDTO getLoan() {
		return loan;
	}

	public void setLoan(LoandetailsDTO loan) {
		this.loan = loan;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public SavingsDTO getSavings() {
		return savings;
	}

	public void setSavings(SavingsDTO savings) {
		this.savings = savings;
	}

	public CurrentDTO getCurrent() {
		return current;
	}

	public void setCurrent(CurrentDTO current) {
		this.current = current;
	}

	public CreditDTO getCredit() {
		return credit;
	}

	public void setCredit(CreditDTO credit) {
		this.credit = credit;
	}
}
