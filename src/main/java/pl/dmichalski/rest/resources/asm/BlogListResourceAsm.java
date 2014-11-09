package pl.dmichalski.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import pl.dmichalski.core.services.util.BlogList;
import pl.dmichalski.rest.mvc.BlogController;
import pl.dmichalski.rest.resources.BlogListResource;

/**
 * Author: Daniel
 */
public class BlogListResourceAsm extends ResourceAssemblerSupport<BlogList, BlogListResource> {

    public BlogListResourceAsm() {
        super(BlogController.class, BlogListResource.class);
    }

    @Override
    public BlogListResource toResource(BlogList blogList) {
        BlogListResource res = new BlogListResource();
        res.setBlogs(new BlogResourceAsm().toResources(blogList.getBlogs()));
        return res;
    }
}
