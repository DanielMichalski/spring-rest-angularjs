package pl.dmichalski.rest.service;

import pl.dmichalski.rest.entity.BlogEntry;

/**
 * Author: Daniel
 */
public interface BlogEntryService {

    BlogEntry findBlogEntry(Long id);

    BlogEntry deleteBlogEntry(Long id);

    BlogEntry updateblogEntry(Long id, BlogEntry data);

}
