package bank.CustomerMS.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bank.CustomerMS.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {

	CustomerEntity findByEmail(String emailId);

	CustomerEntity findByPhonenumber(Integer phonenumber);
	
	CustomerEntity getAccountId(String email, String password);
	
}
