package com.example.blogging_app.service;

import com.example.blogging_app.Repository.AuthorRepository;
import com.example.blogging_app.dto.AuthorDto;
import com.example.blogging_app.model.Author;
import com.example.blogging_app.model.BlogPost;
import exception.AuthorNotFoundException;
import exception.BlogPostNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BlogPostService blogPostService;

    public Author saveAuthor(AuthorDto autoreDto) throws BlogPostNotFoundException {
        BlogPost blogPost = blogPostService.getBlogPost(autoreDto.getBlogPostId());

        Author author = new Author();
        author.setNome(autoreDto.getNome());
        author.setCognome(autoreDto.getCognome());
        author.setEmail(autoreDto.getEmail());
        author.setAvatar(autoreDto.getAvatar());
        author.setDataNascita(autoreDto.getDataNascita());
        author.setBlogPost(blogPost);

        return authorRepository.save(author);
    }

    public Author getAutore(int id) throws AuthorNotFoundException {
        return authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Autore non trovato con ID: " + id));
    }

    public Page<Author> getAllAuthor(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return authorRepository.findAll(pageable);
    }

    public Author updateAuthor(int id, AuthorDto autoreDto) throws AuthorNotFoundException, BlogPostNotFoundException {
        Author autoreDaCercare = getAutore(id);

        autoreDaCercare.setNome(autoreDto.getNome());
        autoreDaCercare.setCognome(autoreDto.getCognome());
        autoreDaCercare.setEmail(autoreDto.getEmail());
        autoreDaCercare.setAvatar(autoreDto.getAvatar());
        autoreDaCercare.setDataNascita(autoreDto.getDataNascita());

        if (autoreDaCercare.getBlogPost().getId() != autoreDto.getBlogPostId()) {
            BlogPost blogPost = blogPostService.getBlogPost(autoreDto.getBlogPostId());
            autoreDaCercare.setBlogPost(blogPost);
        }

        return authorRepository.save(autoreDaCercare);
    }

    public void deleteAutore(int id) throws AuthorNotFoundException {
        Author autoreDaRimuovere = getAutore(id);
        authorRepository.delete(autoreDaRimuovere);
    }
}
