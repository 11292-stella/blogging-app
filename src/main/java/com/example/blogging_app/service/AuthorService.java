package com.example.blogging_app.service;

import com.example.blogging_app.model.Author;
import exception.AuthorNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {

    private List<Author> autori = new ArrayList<>();

    public Author saveAuthor(Author autore){

        autore.setId(new Random().nextInt(1,2000));

        autori.add(autore);
        return autore;
    }

    public Author getAutore(int id)  throws AuthorNotFoundException {
        return autori.stream().filter(autore -> autore.getId() == id )
                .findFirst().orElseThrow(() -> new AuthorNotFoundException("autore non trovato" + id));
    }

    public List<Author> getAllAuthor(){
        return autori;
    }

    public Author updateAuthor(int id,Author autore) throws AuthorNotFoundException{
        Author autoreDaCercare = getAutore(id);

        autoreDaCercare.setNome(autore.getNome());
        autoreDaCercare.setCognome(autore.getCognome());
        autoreDaCercare.setEmail(autore.getEmail());
        autoreDaCercare.setAvatar(autoreDaCercare.getAvatar());
        autoreDaCercare.setDataNascita(autore.getDataNascita());
        return autoreDaCercare;
    }

    public void deleteAutore(int id)throws AuthorNotFoundException{
        Author autoreDaRimuovere = getAutore(id);
        autori.remove(autoreDaRimuovere);
    }
}
