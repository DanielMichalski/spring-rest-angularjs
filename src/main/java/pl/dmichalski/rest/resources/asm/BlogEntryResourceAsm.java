package pl.dmichalski.rest.resources.asm;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import pl.dmichalski.core.models.entities.BlogEntry;
import pl.dmichalski.rest.mvc.BlogController;
import pl.dmichalski.rest.mvc.BlogEntryController;
import pl.dmichalski.rest.resources.BlogEntryResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * Author: Daniel
 */
public class BlogEntryResourceAsm extends ResourceAssemblerSupport<BlogEntry, BlogEntryResource> {

    public BlogEntryResourceAsm() {
        super(BlogEntryController.class, BlogEntryResource.class);
    }

    @Override
    public BlogEntryResource toResource(BlogEntry blogEntry) {
        BlogEntryResource res = new BlogEntryResource();
        res.setTitle(blogEntry.getTitle());
        Link self = linkTo(BlogEntryController.class).slash(blogEntry.getId()).withSelfRel();
        res.add(self);
        if (blogEntry.getBlog() != null) {
            res.add((linkTo(BlogController.class).slash(blogEntry.getBlog().getId()).withRel("blog")));
        }
        return res;
    }

}
