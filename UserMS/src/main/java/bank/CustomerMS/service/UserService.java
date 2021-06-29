package bank.CustomerMS.service;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

//package bank.UserMS.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import bank.CustomerMS.DTO.AccountDTO;
import bank.CustomerMS.DTO.CustomerDTO;
import bank.CustomerMS.entity.CustomerHistory;
import bank.CustomerMS.entity.CustomerEntity;
import bank.CustomerMS.exception.UserException;
import bank.CustomerMS.repository.AccountRepository;
import bank.CustomerMS.repository.CustomerAuthRepository;
import bank.CustomerMS.repository.CustomerRepository;
import bank.CustomerMS.validation.UserValidator;

@Service
@PropertySource(value = { "classpath:configuration.properties" })
public class UserService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
//	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);//Check
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	CustomerAuthRepository customerAuthRepository;

	public Long getCustomerId(String email, String password) {
		CustomerEntity customerEntity = customerRepository.getAccountId(email, password);// getting customerid from repo
		return customerEntity.getAccount().getCustomerId();
	}

	public AccountDTO getAccDetails(Long customerId, AccountDTO accDTO) {
//		AccountEntity ae=accountRepository.getByAccountId(accountId);
		AccountDTO adto = null;
		if (accDTO != null) {
			adto = AccountDTO.valueOf(accDTO);

		}
		return adto;

	}

	public String userLogin(CustomerDTO customerDTO) throws UserException {

		CustomerEntity customerEntity = customerRepository.findByEmail(customerDTO.getEmail());// check
		if (customerEntity != null) {
			if (customerEntity.getPassword().equals(customerDTO.getPassword())) {
				return "Successful Login";
			} else {
				return "Invalid Password";
			}

		} else {
			return "INVALID EMAILID";
		}

	}

	public void logData(CustomerDTO userDto) {
		CustomerHistory uae = new CustomerHistory();

		uae.setCustomerId(userDto.getCustomerId());
		uae.setEmail(userDto.getEmail());	
		
		LocalTime localTime = LocalTime.now(ZoneId.of("GMT+05:30"));
		uae.setLoginTime(localTime);
		
//		uae.setLoggedDate(new Timestamp(System.currentTimeMillis()));
//		String pk = userDto.getCustomerId().toString() + "_" + new Time(System.currentTimeMillis()).toString();
//		uae.setPkLoggedDate(pk);
		customerAuthRepository.save(uae);
	}

	public String checkUser(Integer customerId) {
		List<CustomerHistory> entity = customerAuthRepository.findByCustomerId(customerId);
		String value = null;
		for (CustomerHistory uE : entity) {
			if (uE.getCustomerId().equals(customerId)) {
				value = "true";
			}
		}
		if (value.equals("true")) {
			value = "true";
		} else {
			value = "false";
		}

		return value;

	}

	public CustomerDTO getCustomer(Integer id) {
		Optional<CustomerEntity> cust=customerRepository.findById(id);
		CustomerHistory hist=customerAuthRepository.getOne(id);
		UserValidator.validateUserLogTime(hist);
		return null;
	}
}
