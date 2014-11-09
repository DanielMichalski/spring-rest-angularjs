package pl.dmichalski.core.models.entities;

/**
 * Author: Daniel
 */
public class BlogEntry {

    private Long id;

    private String title;

    private Blog blog;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

}
