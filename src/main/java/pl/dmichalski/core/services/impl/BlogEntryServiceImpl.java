package pl.dmichalski.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmichalski.core.models.entities.BlogEntry;
import pl.dmichalski.core.repositories.BlogEntryRepo;
import pl.dmichalski.core.services.BlogEntryService;

/**
 * Author: Daniel
 */
@Service
@Transactional
public class BlogEntryServiceImpl implements BlogEntryService {

    @Autowired
    private BlogEntryRepo blogEntryRepo;

    @Override
    public BlogEntry findBlogEntry(Long id) {
        return blogEntryRepo.findBlogEntry(id);
    }

    @Override
    public BlogEntry deleteBlogEntry(Long id) {
        return blogEntryRepo.deleteBlogEntry(id);
    }

    @Override
    public BlogEntry updateBlogEntry(Long id, BlogEntry data) {
        return blogEntryRepo.updateBlogEntry(id, data);
    }

}
