package bank.CustomerMS.controller;

import java.sql.Time;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import bank.CustomerMS.DTO.AccountDTO;
import bank.CustomerMS.DTO.CustomerDTO;
import bank.CustomerMS.service.UserService;


@CrossOrigin
@RestController
@RequestMapping(value = "/bank")
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserService userService;
	
	@Autowired
	Environment environment;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);//check

	@GetMapping(value="/accountDetails/{customerId}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public AccountDTO viewDetails(@PathVariable Long customerId) {
		AccountDTO accDTO=new RestTemplate().getForObject("http://localhost:8000/summary/"+customerId, AccountDTO.class);
			logger.info("Account details of ", customerId);
			AccountDTO accDetails=userService.getAccDetails(customerId,accDTO);
			return accDetails;
		}
	
	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public Time getCustomer(@RequestBody CustomerDTO customerDTO ) {
		
		CustomerDTO dto=null;
		dto=userService.getCustomer(customerDTO.getCustomerId());
		userService.logData(dto);
		return null;
	}
	
	
	
	/*@GetMapping(value="/user/{customerId}")
	public String findUser(@PathVariable Integer customerId) {
		String response=userService.checkUser(customerId);
		return response;
	}*/
	

	
	//Login Customer
	@PostMapping(value = "/customerlogin",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> userLogin(@RequestBody CustomerDTO customerDTO) {

		ResponseEntity<String> responseEntity = null;
		try {
			
			String success = "Login Successful";
			
			String responseMessage = userService.userLogin(customerDTO);//check
			if(success.equals(responseMessage)) {
				
				Long customerId=userService.getCustomerId(customerDTO.getEmail(), customerDTO.getPassword());
				AccountDTO accDTO=new RestTemplate().getForObject("http://localhost:8000/summary/"+customerId, AccountDTO.class);
				
				AccountDTO adto =userService.getAccDetails(customerId,accDTO);
				
				
				//LoandetailsDTO ldto = new RestTemplate().getForObject("http://localhost:5000/loans/loandetails/" + accountDto.getLoanDto().getLoanId(),LoandetailsDTO.class);
				
				String responseMsg = "Login Successful \n"+adto.toString();
				
				customerDTO.setCustomerId(adto.getCustomerId());
				
				userService.logData(customerDTO);
				
				responseEntity = new ResponseEntity<String>(responseMsg, HttpStatus.OK);
				return responseEntity;
			}
			responseEntity = new ResponseEntity<String>(responseMessage, HttpStatus.OK);

		} catch (Exception exception) {
			LOGGER.error("Error: " + exception.getMessage(), exception);

			String errorMessage;

			if (exception.getMessage() == null) {
				errorMessage = environment.getProperty("General.EXCEPTION");
				responseEntity = new ResponseEntity<String>(errorMessage, HttpStatus.OK);
				return responseEntity;

			} else {
				errorMessage = environment.getProperty(exception.getMessage());

				if (errorMessage == null)
					errorMessage = environment.getProperty("General.EXCEPTION");
				responseEntity = new ResponseEntity<String>(errorMessage, HttpStatus.OK);
				return responseEntity;

			}
		}
		System.out.println(responseEntity);

		return responseEntity;
	}
}















