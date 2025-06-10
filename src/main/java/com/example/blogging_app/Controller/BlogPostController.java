package com.example.blogging_app.Controller;

import com.example.blogging_app.model.BlogPost;
import com.example.blogging_app.service.BlogPostService;
import exception.BlogPostNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @PostMapping("/blogPost")
    public BlogPost creaBlogPost(@RequestBody BlogPost post){
        return blogPostService.saveBlogPost(post);
    }

    @GetMapping("/blogPost/{id}")
    public BlogPost getBlogPost(@PathVariable int id) throws BlogPostNotFoundException{
        return blogPostService.getBlogPost(id);
    }

    @GetMapping("/blogPost")
    public List<BlogPost> getAllBlogPost(){
        return blogPostService.getAllBlogPost();
    }

    @PutMapping("/blogPost/{id}")
    public BlogPost updateBlogPost(@PathVariable int id,@RequestBody BlogPost post)throws BlogPostNotFoundException{
        return blogPostService.updateBlogPost(id,post);
    }

    @DeleteMapping("/blogPost/{id}")
    public void deleteBlogPost(@PathVariable int id)throws BlogPostNotFoundException{
        blogPostService.deleteBlogPost(id);
    }




}
