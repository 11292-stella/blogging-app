package com.example.blogging_app.Controller;

import com.example.blogging_app.model.Author;
import com.example.blogging_app.model.BlogPost;
import com.example.blogging_app.service.AuthorService;
import com.example.blogging_app.service.BlogPostService;
import exception.AuthorNotFoundException;
import exception.BlogPostNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService AuthorService;

    @PostMapping("/author")
    public Author creaAuthor(@RequestBody Author author){
        return AuthorService.saveAuthor(author);
    }

    @GetMapping("/author/{id}")
    public Author getAuthor(@PathVariable int id) throws AuthorNotFoundException {
        return AuthorService.getAutore(id);
    }

    @GetMapping("/author")
    public List<Author> getAllAuthor(){
        return AuthorService.getAllAuthor();
    }

    @PutMapping("/author/{id}")
    public Author updateAuthor(@PathVariable int id,@RequestBody Author author)throws AuthorNotFoundException{
        return AuthorService.updateAuthor(id,author);
    }

    @DeleteMapping("/author/{id}")
    public void deleteAuthor(@PathVariable int id)throws AuthorNotFoundException{
        AuthorService.deleteAutore(id);
    }
}
