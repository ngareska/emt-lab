package mk.ukim.finki.emt_lab.repository;

import mk.ukim.finki.emt_lab.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
