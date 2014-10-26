package pl.dmichalski.rest.resources;

import org.springframework.hateoas.ResourceSupport;

/**
 * Author: Daniel
 */
public class BlogResource extends ResourceSupport {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
