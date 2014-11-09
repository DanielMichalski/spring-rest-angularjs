package pl.dmichalski.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import pl.dmichalski.core.models.entities.Account;
import pl.dmichalski.rest.mvc.AccountController;
import pl.dmichalski.rest.resources.AccountResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * Author: Daniel
 */
public class AccountResourceAsm extends ResourceAssemblerSupport<Account, AccountResource> {

    public AccountResourceAsm() {
        super(AccountController.class, AccountResource.class);
    }

    @Override
    public AccountResource toResource(Account account) {
        AccountResource res = new AccountResource();
        res.setName(account.getName());
        res.setPassword(account.getPassword());
        res.add(linkTo(methodOn(AccountController.class).getAccount(account.getId())).withSelfRel());
        return res;
    }

}
