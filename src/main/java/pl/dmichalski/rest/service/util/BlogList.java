package pl.dmichalski.rest.service.util;

import pl.dmichalski.rest.entity.Blog;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Daniel
 */
public class BlogList {

    private List<Blog> blogs = new ArrayList<>();

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
