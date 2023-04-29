package mk.ukim.finki.emt_lab.service.impl;

import mk.ukim.finki.emt_lab.model.Author;
import mk.ukim.finki.emt_lab.model.Book;
import mk.ukim.finki.emt_lab.model.dto.BookDto;
import mk.ukim.finki.emt_lab.repository.AuthorRepository;
import mk.ukim.finki.emt_lab.repository.BookRepository;
import mk.ukim.finki.emt_lab.service.AuthorService;
import mk.ukim.finki.emt_lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.authorRepository = authorRepository;
    }

    @Override
    public Book findById(Long id) {
        return this.bookRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book create(BookDto book) {
        Book b = new Book();
        Author a = authorService.findById(book.getAuthor());
        Author a2 = authorRepository.findById(book.getAuthor()).orElseThrow();

        b.setName(book.getName());
        b.setCategory(book.getCategory());
        b.setAuthor(a);
        b.setAvailableCopies(book.getAvailableCopies());

        return bookRepository.save(b);
    }

    @Override
    public Book update(Long id, BookDto book) {
        Book b = bookRepository.findById(id).orElse(null);
        Author a = authorService.findById(book.getAuthor());

        if (b == null) {
            return null;
        }
        b.setName(book.getName());
        b.setCategory(book.getCategory());
        b.setAuthor(a);
        b.setAvailableCopies(book.getAvailableCopies());

        return bookRepository.save(b);
    }

    @Override
    public Book delete(Long id) {
        Book book= this.findById(id);
        this.bookRepository.delete(book);
        return book;
    }

    @Override
    public void markBookAsTaken(Long id) {
        Book book= this.findById(id);
        book.setAvailableCopies(book.getAvailableCopies()-1);

        this.bookRepository.save(book);
    }
}
