package pl.dmichalski.core.repositories;

import pl.dmichalski.core.models.entities.Blog;

import java.util.List;

/**
 * Author: Daniel
 */
public interface BlogRepo {

    Blog createBlog(Blog blog);

    List<Blog> findAllBlogs();

    Blog findBlog(Long id);

    Blog findBlogByTitle(String title);

    List<Blog> findBlogsByAccount(Long accountId);

}
