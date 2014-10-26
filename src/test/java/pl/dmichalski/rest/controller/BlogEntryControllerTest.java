package pl.dmichalski.rest.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.dmichalski.rest.entity.BlogEntry;
import pl.dmichalski.rest.service.BlogEntryService;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BlogEntryControllerTest {

    @InjectMocks
    private BlogEntryController controller;

    @Mock
    private BlogEntryService blogEntryService;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testGetBlogEntry() throws Exception {
        mockMvc.perform(get("/")).andDo(print());
    }

    @Test
    public void testPostBlogEntry() throws Exception {
        String jsonObj = "{\"title\":\"Test Blog Title\"}";
        mockMvc.perform(post("/")
                        .content(jsonObj)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(jsonPath("$.title", is("Test Blog Title")));
    }

    @Test
    public void testGetExistingBlogEntry() throws Exception {
        BlogEntry blogEntry = new BlogEntry();
        blogEntry.setId(1L);
        blogEntry.setTitle("Test title");
        when(blogEntryService.find(1L)).thenReturn(blogEntry);

        mockMvc.perform(get("/blog-entries/1"))
                .andExpect(jsonPath("$.title", is(blogEntry.getTitle())))
                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/blog-entries/1"))))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetNonExistingBlogEntry() throws Exception {
        when(blogEntryService.find(1L)).thenReturn(null);

        mockMvc.perform(get("/blog-entries/1"))
                .andExpect(status().isNotFound());
    }
}