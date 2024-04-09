package am.bank;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<am.bank.BankAccount, Long> {
    am.bank.BankAccount findByUserID(long userID);
}
