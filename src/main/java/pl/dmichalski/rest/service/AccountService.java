package pl.dmichalski.rest.service;

import pl.dmichalski.rest.entity.Account;
import pl.dmichalski.rest.entity.Blog;
import pl.dmichalski.rest.resources.AccountResource;
import pl.dmichalski.rest.resources.BlogResource;

/**
 * Author: Daniel
 */
public interface AccountService {

    Account findAccount(Long id);

    Account createAccount(AccountResource data);

    Blog createBlog(Long accountId, BlogResource data);

}
