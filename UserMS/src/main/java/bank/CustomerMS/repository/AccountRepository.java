package bank.CustomerMS.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bank.CustomerMS.entity.AccountEntity;
import bank.CustomerMS.entity.CustomerEntity;

//import com.infosys.project.user.entity.AccountEntity;
@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long>{

	AccountEntity getByCustomerId(Long customerId);
    
}
