package mk.ukim.finki.emt_lab.service.impl;

import mk.ukim.finki.emt_lab.model.Author;
import mk.ukim.finki.emt_lab.model.Country;
import mk.ukim.finki.emt_lab.model.dto.AuthorDto;
import mk.ukim.finki.emt_lab.repository.AuthorRepository;
import mk.ukim.finki.emt_lab.repository.CountryRepository;
import mk.ukim.finki.emt_lab.service.AuthorService;
import mk.ukim.finki.emt_lab.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryService countryService;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository, CountryService countryService) {
        this.authorRepository = authorRepository;
        this.countryService = countryService;
    }

    @Override
    public Author findById(Long id) {
        return this.authorRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Author> listAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author create(AuthorDto author) {
        Author a = new Author();
        Country c = countryService.findById(author.getCountry());
        if (c == null) {
            return null;
        }

        a.setName(author.getName());
        a.setSurname(author.getSurname());
        a.setCountry(c);

        return authorRepository.save(a);
    }

    @Override
    public Author update(Long id, AuthorDto author) {
        Author a = authorRepository.findById(id).orElse(null);
        Country c = countryService.findById(author.getCountry());
        if (a == null) {
            return null;
        }
        if (c == null) {
            return null;
        }

        a.setName(author.getName());
        a.setSurname(author.getSurname());
        a.setCountry(c);

        return authorRepository.save(a);
    }



    @Override
    public Author delete(Long id) {
        Author author= this.findById(id);
        this.authorRepository.delete(author);
        return author;
    }
}
