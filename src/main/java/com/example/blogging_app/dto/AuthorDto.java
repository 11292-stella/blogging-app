package com.example.blogging_app.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AuthorDto {


    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;
    private String avatar;
    private int blogPostId;
}
