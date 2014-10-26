package pl.dmichalski.rest.resources.asm;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import pl.dmichalski.rest.controller.BlogEntryController;
import pl.dmichalski.rest.entity.BlogEntry;
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
    public BlogEntryResource toResource(BlogEntry entity) {
        BlogEntryResource res = new BlogEntryResource();
        res.setTitle(entity.getTitle());
        Link link = linkTo(methodOn(BlogEntryController.class).getBlogEntry(entity.getId())).withSelfRel();
        res.add(link.withSelfRel());
        return res;
    }
}
