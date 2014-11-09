package pl.dmichalski.core.services;

import pl.dmichalski.core.models.entities.Account;
import pl.dmichalski.core.models.entities.Blog;
import pl.dmichalski.core.services.exceptions.BlogExistsException;

/**
 * Author: Daniel
 */
public interface AccountService {

    public Account findAccount(Long id);

    public Account createAccount(Account data);

    public Blog createBlog(Long accountId, Blog data) throws BlogExistsException;

}
