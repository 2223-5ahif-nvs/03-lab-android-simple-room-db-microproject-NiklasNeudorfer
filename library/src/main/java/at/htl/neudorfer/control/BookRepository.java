package at.htl.neudorfer.control;

import at.htl.neudorfer.entity.Author;
import at.htl.neudorfer.entity.Book;
import at.htl.neudorfer.entity.Genre;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BookRepository {

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();

        books.add(new Book(
                1,
                "Harry Potter und der Stein der Weisen", "Harry Potter wird in die Welt der Zauberer eingeführt",
                Genre.FANTASY,
                new Author(1, "J.K.", "Rowling"))
        );
        books.add(new Book(
                2,
                "The Song of Ice and Fire",
                "The Song of Ice and Fire is a series of epic fantasy novels by the American novelist and screenwriter George R. R. Martin.",
                Genre.FANTASY,
                new Author(2, "George RR", "Martin"))
        );
        books.add(new Book(
                3,
                "Attack on Titan",
                "Attack on Titan is a Japanese manga series written and illustrated by Hajime Isayama. " +
                        "It is set in a world where humanity lives within territories surrounded by three enormous walls that protect them from...",
                Genre.FANTASY,
                new Author(3, "Hajime", "Isayama"))
        );
        books.add(new Book(
                4,
                "Dune",
                "Dune is a 1965 science fiction novel by American author Frank Herbert, originally published as two separate serials in Analog magazine.",
                Genre.SCIENCE_FICTION,
                new Author(4, "Frank", "Herbert"))
        );

        return books;
    }
}
