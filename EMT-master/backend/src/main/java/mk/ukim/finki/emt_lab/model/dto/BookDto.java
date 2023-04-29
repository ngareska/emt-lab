package mk.ukim.finki.emt_lab.model.dto;

import lombok.Data;
import mk.ukim.finki.emt_lab.model.enums.Category;

@Data
public class BookDto {
    private String name;

    private Category category;

    private Long author;

    private Integer availableCopies;

    public BookDto() {
    }

    public BookDto(String name, Category category, Long author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}