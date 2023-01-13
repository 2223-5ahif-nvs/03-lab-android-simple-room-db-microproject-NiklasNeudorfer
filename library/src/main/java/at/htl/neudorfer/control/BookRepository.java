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


        try (var file = Files.lines(Paths.get("src/main/resources/books-shortened.csv"));) {

            file.skip(1).map(line ->
                    line.replace("\"", "")
                            .split(";")).forEach(line -> {


                books.add(
                        new Book(
                                line[0].trim(),
                                line[1].trim(),
                                Genre.values()[new Random().nextInt(Genre.values().length)],
                                Integer.parseInt(line[3].trim()),
                                new Author(line[2].trim()),
                                new Publisher(line[4].trim()),
                                line[5].trim(),
                                line[6].trim(),
                                line[7].trim()
                        )
                );
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return books;
    }
}
