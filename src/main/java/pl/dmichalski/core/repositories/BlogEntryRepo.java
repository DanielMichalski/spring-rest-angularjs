package pl.dmichalski.core.repositories;

import pl.dmichalski.core.models.entities.BlogEntry;

import java.util.List;

/**
 * Author: Daniel
 */
public interface BlogEntryRepo {

    BlogEntry findBlogEntry(Long id);

    BlogEntry deleteBlogEntry(Long id);

    BlogEntry updateBlogEntry(Long id, BlogEntry data);

    BlogEntry createBlogEntry(BlogEntry blogEntry);

    List<BlogEntry> findByBlogId(Long blogId);

}
