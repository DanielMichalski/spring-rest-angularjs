package pl.dmichalski.core.services.util;

import pl.dmichalski.core.models.entities.BlogEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Daniel
 */
public class BlogEntryList {

    private List<BlogEntry> entries;

    private Long blogId;

    public BlogEntryList(Long blogId, List<BlogEntry> entries) {
        this.blogId = blogId;
        this.entries = entries;
    }

    public List<BlogEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<BlogEntry> entries) {
        this.entries = entries;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

}
