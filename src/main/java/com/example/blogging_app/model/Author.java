package com.example.blogging_app.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Author {

    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;
    private String avatar;

}
