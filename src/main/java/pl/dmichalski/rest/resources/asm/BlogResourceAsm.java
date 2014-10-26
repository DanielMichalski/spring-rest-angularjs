package pl.dmichalski.rest.resources.asm;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import pl.dmichalski.rest.controller.BlogController;
import pl.dmichalski.rest.controller.BlogEntryController;
import pl.dmichalski.rest.entity.Blog;
import pl.dmichalski.rest.resources.BlogResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Author: Daniel
 */
public class BlogResourceAsm extends ResourceAssemblerSupport<Blog, BlogResource> {

    public BlogResourceAsm() {
        super(BlogController.class, BlogResource.class);
    }

    @Override
    public BlogResource toResource(Blog entity) {
        BlogResource res = new BlogResource();
        res.setTitle(entity.getTitle());
        Link link = linkTo(methodOn(BlogEntryController.class).getBlogEntry(entity.getId())).withSelfRel();
        res.add(link.withSelfRel());
        return res;
    }
}
