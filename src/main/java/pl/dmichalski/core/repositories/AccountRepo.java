package pl.dmichalski.core.repositories;

import pl.dmichalski.core.models.entities.Account;

import java.util.List;

/**
 * Author: Daniel
 */
public interface AccountRepo {

    List<Account> findAllAccounts();

    Account findAccount(Long id);

    Account findAccountByName(String name);

    Account createAccount(Account data);

}
