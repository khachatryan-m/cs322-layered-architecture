package am.bank;

import am.bank.model.BalanceRequests;
import am.bank.model.BankAccountDTO;
import am.bank.model.CreateAccountRequest;

public interface BankAccountController {

    public BankAccountDTO createAccount(CreateAccountRequest request);

    public double debit(Long id, BalanceRequests request);

    public double credit(Long id, BalanceRequests request);

}
