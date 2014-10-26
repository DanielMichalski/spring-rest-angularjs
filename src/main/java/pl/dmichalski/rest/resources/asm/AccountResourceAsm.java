package pl.dmichalski.rest.resources.asm;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import pl.dmichalski.rest.controller.AccountController;
import pl.dmichalski.rest.controller.BlogEntryController;
import pl.dmichalski.rest.entity.Account;
import pl.dmichalski.rest.resources.AccountResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Author: Daniel
 */
public class AccountResourceAsm extends ResourceAssemblerSupport<Account, AccountResource> {

    public AccountResourceAsm() {
        super(AccountController.class, AccountResource.class);
    }

    @Override
    public AccountResource toResource(Account entity) {
        AccountResource res = new AccountResource();
        res.setName(entity.getName());
        Link link = linkTo(methodOn(BlogEntryController.class).getBlogEntry(entity.getId())).withSelfRel();
        res.add(link.withSelfRel());
        return res;
    }
}
