package com.example.blogging_app.Controller;

import com.example.blogging_app.dto.AuthorDto;
import com.example.blogging_app.model.Author;
import com.example.blogging_app.model.BlogPost;
import com.example.blogging_app.service.AuthorService;
import com.example.blogging_app.service.BlogPostService;
import exception.AuthorNotFoundException;
import exception.BlogPostNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/author")
public class AuthorController {

    @Autowired
    private AuthorService AuthorService;

    @PostMapping("")
    public Author creaAuthor(@RequestBody AuthorDto authorDto) throws ChangeSetPersister.NotFoundException {
        return AuthorService.saveAuthor(authorDto);
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable int id) throws AuthorNotFoundException {
        return AuthorService.getAutore(id);
    }

    @GetMapping("")
    public Page<Author> getAllAuthor(@RequestParam(defaultValue = "0")int page,
                                     @RequestParam(defaultValue = "10") int size,
                                     @RequestParam(defaultValue = "matricola") String sortBy){
        return AuthorService.getAllAuthor(page,size,sortBy);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable int id,@RequestBody Author author)throws AuthorNotFoundException{
        return AuthorService.updateAuthor(id,author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable int id)throws AuthorNotFoundException{
        AuthorService.deleteAutore(id);
    }
}
