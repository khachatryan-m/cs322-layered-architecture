package am.bank;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<am.bank.BankAccount, Long> {
    am.bank.BankAccount findByUserID(long userID);
}
