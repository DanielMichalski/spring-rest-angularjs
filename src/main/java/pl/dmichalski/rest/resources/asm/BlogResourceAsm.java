package pl.dmichalski.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import pl.dmichalski.core.models.entities.Blog;
import pl.dmichalski.rest.mvc.AccountController;
import pl.dmichalski.rest.mvc.BlogController;
import pl.dmichalski.rest.resources.BlogResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * Author: Daniel
 */
public class BlogResourceAsm extends ResourceAssemblerSupport<Blog, BlogResource> {

    public BlogResourceAsm() {
        super(BlogController.class, BlogResource.class);
    }

    @Override
    public BlogResource toResource(Blog blog) {
        BlogResource resource = new BlogResource();
        resource.setTitle(blog.getTitle());
        resource.add(linkTo(BlogController.class).slash(blog.getId()).withSelfRel());
        resource.add(linkTo(BlogController.class).slash(blog.getId()).slash("entries").withRel("entries"));
        if (blog.getOwner() != null)
            resource.add(linkTo(AccountController.class).slash(blog.getOwner().getId()).withRel("owner"));
        return resource;
    }

}
