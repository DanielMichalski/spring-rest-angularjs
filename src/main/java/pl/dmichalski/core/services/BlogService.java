package pl.dmichalski.core.services;

import pl.dmichalski.core.models.entities.Blog;
import pl.dmichalski.core.services.util.BlogEntryList;
import pl.dmichalski.core.models.entities.BlogEntry;
import pl.dmichalski.core.services.util.BlogList;

/**
 * Author: Daniel
 */
public interface BlogService {
    /**
     * @param blogId the id of the blog to add this BlogEntry to
     * @param data   the BlogEntry containing the data to be used for creating the new entity
     * @return the created BlogEntry with a generated ID
     * @throws pl.dmichalski.core.services.exceptions.BlogNotFoundException if the blog to add to cannot be found
     */
    public BlogEntry createBlogEntry(Long blogId, BlogEntry data);

    public BlogList findAllBlogs();

    public BlogEntryList findAllBlogEntries(Long blogId); // findBlog all associated blog entries

    public Blog findBlog(Long eq);
}
