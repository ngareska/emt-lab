package mk.ukim.finki.emt_lab.service;

import mk.ukim.finki.emt_lab.model.Author;
import mk.ukim.finki.emt_lab.model.dto.AuthorDto;
import mk.ukim.finki.emt_lab.model.dto.CategoryDto;
import mk.ukim.finki.emt_lab.model.enums.Category;

import java.util.List;

public interface CategoryService {
    Category findById(Long id);

    List<Category> listAll();

    Category create(CategoryDto author);
}
