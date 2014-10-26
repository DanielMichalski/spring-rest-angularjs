package pl.dmichalski.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.dmichalski.rest.controller.exception.ResourceNotFoundException;
import pl.dmichalski.rest.entity.BlogEntry;
import pl.dmichalski.rest.resources.BlogEntryResource;
import pl.dmichalski.rest.resources.asm.BlogEntryResourceAsm;
import pl.dmichalski.rest.service.BlogEntryService;

import javax.annotation.Resource;

/**
 * Author: Daniel
 */
@Controller
public class BlogEntryController {

    @Resource
    private BlogEntryService service;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody BlogEntry getBlogEntry() {
        BlogEntry entry = new BlogEntry();
        entry.setTitle("Test title");
        return entry;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody BlogEntry postBlogEntry(@RequestBody BlogEntry blogEntry) {
        return blogEntry;
    }

    @RequestMapping(value = "/blog-entries/{blogEntryId}",method = RequestMethod.GET)
    public @ResponseBody BlogEntryResource getBlogEntry(@PathVariable Long blogEntryId) {
        BlogEntry blogEntry = service.find(blogEntryId);

        if (blogEntry != null) {
            BlogEntryResource res = new BlogEntryResourceAsm().toResource(blogEntry);
            return res;
        } else {
            throw new ResourceNotFoundException();
        }
    }
}
