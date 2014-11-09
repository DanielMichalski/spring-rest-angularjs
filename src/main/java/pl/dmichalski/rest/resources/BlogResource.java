package pl.dmichalski.rest.resources;

import org.springframework.hateoas.ResourceSupport;
import pl.dmichalski.core.models.entities.Blog;

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

    public Blog toBlog() {
        Blog blog = new Blog();
        blog.setTitle(title);
        return blog;
    }
}
