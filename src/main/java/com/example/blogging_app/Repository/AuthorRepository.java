package com.example.blogging_app.Repository;

import com.example.blogging_app.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
