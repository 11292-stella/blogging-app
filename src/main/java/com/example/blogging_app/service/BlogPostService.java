package com.example.blogging_app.service;

import com.example.blogging_app.Repository.BlogPostRepository;
import com.example.blogging_app.model.BlogPost;
import exception.BlogPostNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service

public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    public BlogPost saveBlogPost(BlogPost post) {
        return blogPostRepository.save(post);
    }

    public BlogPost getBlogPost(int id) throws BlogPostNotFoundException {
        return blogPostRepository.findById(id)
                .orElseThrow(() -> new BlogPostNotFoundException("Il blogPost non esiste con ID: " + id));
    }

    public List<BlogPost> getAllBlogPost() {
        return blogPostRepository.findAll();
    }

    public BlogPost updateBlogPost(int id, BlogPost post) throws BlogPostNotFoundException {
        BlogPost postDaAggiornare = getBlogPost(id);

        postDaAggiornare.setContenuto(post.getContenuto());
        postDaAggiornare.setCategoria(post.getCategoria());
        postDaAggiornare.setTitolo(post.getTitolo());
        postDaAggiornare.setTempoDiLettura(post.getTempoDiLettura());
        postDaAggiornare.setCover(post.getCover());

        return blogPostRepository.save(postDaAggiornare);
    }

    public void deleteBlogPost(int id) throws BlogPostNotFoundException {
        BlogPost blogPostDaRimuovere = getBlogPost(id);
        blogPostRepository.delete(blogPostDaRimuovere);
    }
}
