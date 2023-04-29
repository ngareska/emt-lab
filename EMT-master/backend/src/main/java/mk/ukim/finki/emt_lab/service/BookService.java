package mk.ukim.finki.emt_lab.service;

import mk.ukim.finki.emt_lab.model.Author;
import mk.ukim.finki.emt_lab.model.Book;
import mk.ukim.finki.emt_lab.model.dto.BookDto;
import mk.ukim.finki.emt_lab.model.enums.Category;

import java.util.List;

public interface BookService {

    Book findById(Long id);

    List<Book> listAll();

    Book create(BookDto book);

    Book update(Long id, BookDto book);

    Book delete(Long id);

    void markBookAsTaken(Long id);
}
