package pl.dmichalski.core.services.util;

import pl.dmichalski.core.models.entities.BlogEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Daniel
 */
public class BlogEntryList {
    private List<BlogEntry> entries = new ArrayList<BlogEntry>();
    private Long blogId;

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
