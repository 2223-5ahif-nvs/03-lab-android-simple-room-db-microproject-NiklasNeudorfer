package at.htl.neudorfer.entity;

import lombok.Data;

@Data
public class Book {
    private int id;
    private String title;
    private String description;
    private String coverUrl;
    private Genre genre;
    private Author author;

    public Book(int id, String title, String description, String coverUrl, Genre genre, Author author) {
        this.id = id;
        this.title = title;
        this.coverUrl = coverUrl;
        this.description = description;
        this.genre = genre;
        this.author = author;
    }
}
