package am.bank;

import am.bank.model.*;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public BankAccountDTO createAccount(long userID) {
        am.bank.BankAccount createdAccount = accountRepository
                .save((new am.bank.BankAccount(0, userID)));
        return new BankAccountDTO(createdAccount.getId(),createdAccount.getUserID(), createdAccount.getBalance());
    }

    @Override
    public double debit(long userID, double amount) {
        am.bank.BankAccount account = accountRepository.findByUserID(userID);
        if(account == null)
            throw new RuntimeException("Account not found");
        double balance = account.getBalance();
        if (balance < amount)
            throw new RuntimeException("Insufficient balance");

        balance -= amount;
        account.setBalance(balance);
        accountRepository.save(account);
        return account.getBalance();
    }

    @Override
    public double credit(long userID, double amount) {
        am.bank.BankAccount account = accountRepository.findByUserID(userID);
        if (account == null)
            throw new RuntimeException("Account not found");

        double balance = account.getBalance();
        balance += amount;
        account.setBalance(balance);
        accountRepository.save(account);
        return account.getBalance();
    }


}

