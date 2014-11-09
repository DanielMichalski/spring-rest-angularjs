package pl.dmichalski.core.services.util;


import pl.dmichalski.core.models.entities.Account;

import java.util.List;

/**
 * Author: Daniel
 */
public class AccountsList {

    private List<Account> accounts;

    public AccountsList(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

}
