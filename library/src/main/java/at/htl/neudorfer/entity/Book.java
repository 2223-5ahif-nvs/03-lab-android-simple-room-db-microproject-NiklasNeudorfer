package at.htl.neudorfer.entity;

import lombok.Data;

@Data
public class Book {

    private String isbn;
    private String title;
    private Genre genre;
    private int yearOfPublication;


    private Author author;
    private Publisher publisher;


    // Image Urls
    private String coverUrlSmall;
    private String coverUrlMedium;
    private String coverUrlLarge;


    public Book(String isbn, String title, Genre genre,
                int yearOfPublication, Author author, Publisher publisher,
                String coverUrlSmall, String coverUrlMedium, String coverUrlLarge
    ) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.yearOfPublication = yearOfPublication;
        this.author = author;
        this.publisher = publisher;
        this.coverUrlSmall = coverUrlSmall;
        this.coverUrlMedium = coverUrlMedium;
        this.coverUrlLarge = coverUrlLarge;
    }
}
