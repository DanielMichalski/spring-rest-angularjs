package pl.dmichalski.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import pl.dmichalski.core.services.util.BlogEntryList;
import pl.dmichalski.rest.mvc.BlogController;
import pl.dmichalski.rest.resources.BlogEntryListResource;
import pl.dmichalski.rest.resources.BlogEntryResource;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * Author: Daniel
 */
public class BlogEntryListResourceAsm extends ResourceAssemblerSupport<BlogEntryList, BlogEntryListResource> {
    public BlogEntryListResourceAsm() {
        super(BlogController.class, BlogEntryListResource.class);
    }

    @Override
    public BlogEntryListResource toResource(BlogEntryList list) {
        List<BlogEntryResource> resources = new BlogEntryResourceAsm().toResources(list.getEntries());
        BlogEntryListResource listResource = new BlogEntryListResource();
        listResource.setEntries(resources);
        listResource.add(linkTo(methodOn(BlogController.class).findAllBlogEntries(list.getBlogId())).withSelfRel());
        return listResource;
    }
}
