package pl.dmichalski.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmichalski.core.models.entities.Account;
import pl.dmichalski.core.models.entities.Blog;
import pl.dmichalski.core.repositories.AccountRepo;
import pl.dmichalski.core.repositories.BlogRepo;
import pl.dmichalski.core.services.AccountService;
import pl.dmichalski.core.services.exceptions.AccountDoesNotExistException;
import pl.dmichalski.core.services.exceptions.AccountExistsException;
import pl.dmichalski.core.services.exceptions.BlogExistsException;
import pl.dmichalski.core.services.util.AccountsList;
import pl.dmichalski.core.services.util.BlogList;
/**
 * Author: Daniel
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private BlogRepo blogRepo;

    @Override
    public Account findAccount(Long id) {
        return accountRepo.findAccount(id);
    }

    @Override
    public Account createAccount(Account data) {
        Account account = accountRepo.findAccountByName(data.getName());
        if (account != null) {
            throw new AccountExistsException();
        }
        return accountRepo.createAccount(data);
    }

    @Override
    public Blog createBlog(Long accountId, Blog data) throws BlogExistsException {
        Blog blog = blogRepo.findBlogByTitle(data.getTitle());
        if (blog != null) {
            throw new BlogExistsException();
        }

        Account account = accountRepo.findAccount(accountId);
        if (account == null) {
            throw new AccountDoesNotExistException();
        }

        Blog createdBlog = blogRepo.createBlog(data);
        createdBlog.setOwner(account);
        return createdBlog;
    }

    @Override
    public BlogList findBlogsByAccount(Long accountId) {
        Account account = accountRepo.findAccount(accountId);
        if (account == null) {
            throw new AccountDoesNotExistException();
        }
        return new BlogList(blogRepo.findBlogsByAccount(accountId));
    }

    @Override
    public AccountsList findAllAccounts() {
        return new AccountsList(accountRepo.findAllAccounts());
    }

    @Override
    public Account findByAccountName(String name) {
        return accountRepo.findAccountByName(name);
    }
}
