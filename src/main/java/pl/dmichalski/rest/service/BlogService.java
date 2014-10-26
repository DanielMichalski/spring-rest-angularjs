package pl.dmichalski.rest.service;

import pl.dmichalski.rest.entity.Blog;
import pl.dmichalski.rest.entity.BlogEntry;
import pl.dmichalski.rest.service.util.BlogEntryList;
import pl.dmichalski.rest.service.util.BlogList;

/**
 * Author: Daniel
 */
public interface BlogService {

    BlogEntry createBlogEntry(Long blogId, BlogEntry data);

    BlogList findAllBlogs();

    BlogEntryList findAllBlogEntries(Long blogId);

    Blog findBlog(Long eq);
}