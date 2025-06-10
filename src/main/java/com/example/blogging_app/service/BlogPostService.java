package com.example.blogging_app.service;

import com.example.blogging_app.model.BlogPost;
import exception.BlogPostNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {

    private List<BlogPost> posts = new ArrayList<>();

    public BlogPost saveBlogPost(BlogPost post){
        post.setId(new Random().nextInt(1,2000));
        posts.add(post);
        return post;
    }

    public BlogPost getBlogPost(int id) throws BlogPostNotFoundException{
        return posts.stream().filter(blogPost -> blogPost.getId() == id)
                .findFirst().orElseThrow(() -> new BlogPostNotFoundException("il blogPost non esiste" + id));
    }

    public List<BlogPost> getAllBlogPost(){
        return posts;
    }

    public BlogPost updateBlogPost(int id,BlogPost post)throws BlogPostNotFoundException{
        BlogPost postDaCercare= getBlogPost(id);

        postDaCercare.setContenuto(post.getContenuto());
        postDaCercare.setCategoria(post.getCategoria());
        postDaCercare.setTitolo(post.getTitolo());
        postDaCercare.setTempoDiLettura(post.getTempoDiLettura());
        postDaCercare.setCover(post.getCover());
        return postDaCercare;
    }

    public void deleteBlogPost(int id)throws BlogPostNotFoundException{
        BlogPost blogPostDaRimuovere = getBlogPost(id);
        posts.remove(blogPostDaRimuovere);
    }
}
