package pl.dmichalski.rest.resources;

import org.springframework.hateoas.ResourceSupport;
import pl.dmichalski.rest.entity.Account;

/**
 * Author: Daniel
 */
public class BlogEntryResource extends ResourceSupport {

    private String title;

    private Account owner;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }

}