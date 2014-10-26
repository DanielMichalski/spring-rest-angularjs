package pl.dmichalski.rest.resources;

import org.springframework.hateoas.ResourceSupport;

/**
 * Author: Daniel
 */
public class AccountResource extends ResourceSupport {

    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
