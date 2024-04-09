package am.bank;

import am.bank.model.BankAccountDTO;

public interface AccountService {

    BankAccountDTO createAccount(long userID);

    double debit(long userID, double amount);
    double credit(long userID, double amount);



}
