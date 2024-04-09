package am.bank;

import am.bank.model.BalanceRequests;
import am.bank.model.BankAccountDTO;
import am.bank.model.CreateAccountRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/account")
public class BankAccountControllerImpl implements BankAccountController {

    private final AccountService accountService;

    public BankAccountControllerImpl(AccountService accountService){
        this.accountService = accountService;
    }

    @Override
    @PostMapping
    public BankAccountDTO createAccount(@RequestBody CreateAccountRequest request) {
        return accountService.createAccount(request.userId());
    }

    @PostMapping("/debit")
    public double debit(Long id, @RequestBody BalanceRequests debitRequest){
        return accountService.debit(debitRequest.userId(), debitRequest.amount());

    }

    @PostMapping("/credit")
    public double credit(Long id, @RequestBody BalanceRequests creditRequest){
        return accountService.credit(creditRequest.userId(), creditRequest.amount());
    }


}
