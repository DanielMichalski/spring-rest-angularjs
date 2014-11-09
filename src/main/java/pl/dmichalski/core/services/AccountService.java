package pl.dmichalski.core.services;

import pl.dmichalski.core.models.entities.Account;
import pl.dmichalski.core.models.entities.Blog;
import pl.dmichalski.core.services.exceptions.BlogExistsException;
import pl.dmichalski.core.services.util.AccountList;
import pl.dmichalski.core.services.util.BlogList;

/**
 * Author: Daniel
 */
public interface AccountService {

    public Account findAccount(Long id);

    public Account createAccount(Account data);

    public Blog createBlog(Long accountId, Blog data) throws BlogExistsException;

    BlogList findBlogsByAccount(Long accountId);

    AccountList findAllAccounts();

    Account findByAccountName(String name);

}
