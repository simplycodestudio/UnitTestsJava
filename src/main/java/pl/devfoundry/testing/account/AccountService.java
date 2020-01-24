package pl.devfoundry.testing.account;

import java.util.List;
import java.util.stream.Collectors;

public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    List<Account> getAllActiveAccounts() {
        return accountRepository.getAllAccounts()
                .stream()
                .filter(Account::isActive)
                .collect(Collectors.toList());
    }

    void costam() {

        String string1 = "abc";

        string1 = string1 + "xyz";

        string1 = "abc" + "xyz";
    }

 }