package mk.ukim.finki.emt_lab.service;

import mk.ukim.finki.emt_lab.model.Author;
import mk.ukim.finki.emt_lab.model.Country;
import mk.ukim.finki.emt_lab.model.dto.AuthorDto;

import java.util.List;

public interface AuthorService {

    Author findById(Long id);

    List<Author> listAll();

    Author create(AuthorDto author);

    Author update(Long id, AuthorDto author);

    Author delete(Long id);
}
