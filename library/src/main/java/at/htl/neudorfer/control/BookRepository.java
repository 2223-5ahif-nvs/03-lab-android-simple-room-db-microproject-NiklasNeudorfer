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
                "Harry Potter und der Stein der Weisen",
                "Harry Potter wird in die Welt der Zauberer eingeführt",
                "https://en.wikipedia.org/wiki/Harry_Potter_and_the_Philosopher%27s_Stone#/media/File:Harry_Potter_and_the_Philosopher's_Stone_Book_Cover.jpg",
                Genre.FANTASY,
                new Author(1, "J.K.", "Rowling"))
        );
        books.add(new Book(
                2,
                "The Song of Ice and Fire",
                "The Song of Ice and Fire is a series of epic fantasy novels by the American novelist and screenwriter George R. R. Martin.",
                "https://en.wikipedia.org/wiki/A_Song_of_Ice_and_Fire#/media/File:A_Song_of_Ice_and_Fire_book_collection_box_set_cover.jpg",
                Genre.FANTASY,
                new Author(2, "George RR", "Martin"))
        );
        books.add(new Book(
                3,
                "Chainsaw Man",
                "The story is set in a world where Devils are born from human fears. " +
                        "Devils are usually dangerous and malevolent, their power is proportional to the fear " +
                        "they incite. However, humans can form contracts with them to use their power, and there " +
                        "are individuals specializing in hunting and employing them, called Devil Hunters ",
                "https://en.wikipedia.org/wiki/Chainsaw_Man#/media/File:Chainsawman.jpg",
                Genre.THRILLER,
                new Author(3, "Tatsuki", "Fujimoto"))
        );
        books.add(new Book(
                4,
                "Dune",
                "Dune is a 1965 science fiction novel by American author Frank Herbert, originally published as two separate serials in Analog magazine.",
                "https://en.wikipedia.org/wiki/Dune_(franchise)#/media/File:Dune-CardGameCover.jpg",
                Genre.SCIENCE_FICTION,
                new Author(4, "Frank", "Herbert"))
        );

        return books;
    }
}
