package at.htl.neudorfer.control;

import at.htl.neudorfer.entity.Author;
import at.htl.neudorfer.entity.Book;
import at.htl.neudorfer.entity.Genre;
import at.htl.neudorfer.entity.Publisher;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ApplicationScoped
public class BookRepository {

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();


        try (var file = Files.lines(Paths.get("src/main/resources/books.csv"));) {

            file.skip(1).map(line ->
                    line.replace("\"", "")
                            .split(";")).forEach(line -> {


                books.add(
                        new Book(
                                line[0],
                                line[1],
                                Genre.values()[new Random().nextInt(Genre.values().length)],
                                Integer.parseInt(line[3]),
                                new Author(line[2]),
                                new Publisher(line[4]),
                                line[5],
                                line[6],
                                line[7]
                        )
                );
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return books;
    }
}
