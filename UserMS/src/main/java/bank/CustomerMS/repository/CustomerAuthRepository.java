package bank.CustomerMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bank.CustomerMS.entity.CustomerHistory;


@Repository
public interface CustomerAuthRepository extends JpaRepository<CustomerHistory, Integer> {
	List<CustomerHistory>findByCustomerId(Integer customerId);
}
