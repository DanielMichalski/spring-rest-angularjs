package pl.dmichalski.rest.controller;

import com.sun.jndi.toolkit.url.Uri;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.dmichalski.rest.controller.exceptions.BadRequestException;
import pl.dmichalski.rest.controller.exceptions.ResourceNotFoundException;
import pl.dmichalski.rest.entity.Account;
import pl.dmichalski.rest.entity.Blog;
import pl.dmichalski.rest.resources.AccountResource;
import pl.dmichalski.rest.resources.BlogResource;
import pl.dmichalski.rest.resources.asm.AccountResourceAsm;
import pl.dmichalski.rest.resources.asm.BlogResourceAsm;
import pl.dmichalski.rest.service.AccountService;
import pl.dmichalski.rest.service.exception.AccountDoesNotExistException;

import javax.annotation.Resource;
import java.net.URI;

/**
 * Author: Daniel
 */
@Controller
@RequestMapping("/rest/accounts")
public class AccountController {

    @Resource
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody AccountResource createAccount(
            @RequestBody AccountResource sentAccount) {

        Account createdAccount = accountService.createAccount(sentAccount);
        AccountResource res = new AccountResourceAsm().toResource(createdAccount);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(res.getLink("self").getHref()));
        return res;
    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
    public @ResponseBody AccountResource getAccount(@PathVariable Long accountId) {
        Account account = accountService.findAccount(accountId);
        if (account != null) {
            return new AccountResourceAsm().toResource(account);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @RequestMapping(value = "/{accountId}/blogs", method = RequestMethod.POST)
    public @ResponseBody BlogResource createBlog(
            @PathVariable Long accountId,
            @RequestBody BlogResource res) {

        try {
            Blog createdBlog = accountService.createBlog(accountId, res);
            BlogResource createdBlogRes = new BlogResourceAsm().toResource(createdBlog);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdBlogRes.getLink("self").getHref()));
            return createdBlogRes;
        } catch (AccountDoesNotExistException e) {
            throw new BadRequestException(e);
        }
    }

}
