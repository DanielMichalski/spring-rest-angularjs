package pl.dmichalski.core.repositories.jpa;

import org.springframework.stereotype.Repository;
import pl.dmichalski.core.models.entities.Blog;
import pl.dmichalski.core.repositories.BlogRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Author: Daniel
 */
@Repository
public class JpaBlogRepo implements BlogRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Blog createBlog(Blog blog) {
        em.persist(blog);
        return blog;
    }

    @Override
    public List<Blog> findAllBlogs() {
        Query query = em.createQuery("SELECT b FROM Blog b");
        return query.getResultList();
    }

    @Override
    public Blog findBlog(Long id) {
        return em.find(Blog.class, id);
    }

    @Override
    public Blog findBlogByTitle(String title) {
        Query query = em.createQuery("SELECT b FROM Blog b where b.title = ?1");
        query.setParameter(1, title);
        List<Blog> blogs = query.getResultList();
        if (blogs.size() == 0) {
            return null;
        } else {
            return blogs.get(0);
        }
    }

    @Override
    public List<Blog> findBlogsByAccount(Long accountId) {
        Query query = em.createQuery("SELECT b FROM Blog b WHERE b.owner.id = ?1");
        query.setParameter(1, accountId);
        return query.getResultList();
    }
}
