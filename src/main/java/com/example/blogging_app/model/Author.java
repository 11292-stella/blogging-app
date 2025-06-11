package com.example.blogging_app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Author {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;
    private String avatar;


    @ManyToOne
    @JoinColumn(name = "blog_post_id")
    private BlogPost blogPost;

}
