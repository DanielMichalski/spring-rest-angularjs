package pl.dmichalski.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmichalski.core.models.entities.Blog;
import pl.dmichalski.core.models.entities.BlogEntry;
import pl.dmichalski.core.repositories.BlogEntryRepo;
import pl.dmichalski.core.repositories.BlogRepo;
import pl.dmichalski.core.services.BlogService;
import pl.dmichalski.core.services.exceptions.BlogNotFoundException;
import pl.dmichalski.core.services.util.BlogEntryList;
import pl.dmichalski.core.services.util.BlogList;

/**
 * Author: Daniel
 */
@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepo blogRepo;

    @Autowired
    private BlogEntryRepo blogEntryRepo;

    @Override
    public BlogEntry createBlogEntry(Long blogId, BlogEntry data) {
        Blog blog = blogRepo.findBlog(blogId);
        if (blog == null) {
            throw new BlogNotFoundException();
        }
        BlogEntry blogEntry = blogEntryRepo.createBlogEntry(data);
        blogEntry.setBlog(blog);
        return blogEntry;
    }

    @Override
    public BlogList findAllBlogs() {
        return new BlogList(blogRepo.findAllBlogs());
    }

    @Override
    public BlogEntryList findAllBlogEntries(Long blogId) {
        Blog blog = blogRepo.findBlog(blogId);
        if (blog == null) {
            throw new BlogNotFoundException();
        }
        return new BlogEntryList(blogId, blogEntryRepo.findByBlogId(blogId));
    }

    @Override
    public Blog findBlog(Long id) {
        return blogRepo.findBlog(id);
    }

}
