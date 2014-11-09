package pl.dmichalski.core.services.util;

import pl.dmichalski.core.models.entities.Blog;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Daniel
 */
public class BlogList {

    private List<Blog> blogs = new ArrayList<Blog>();

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
