package at.htl.neudorfer.control;

import at.htl.neudorfer.entity.Author;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AuthorRepository {

    public List<Author> getAllAuthors(){
        List<Author> authors = new ArrayList<>();
        authors.add(new Author(1, "Hans", "Peter"));
        authors.add(new Author(2, "George RR", "Martin"));
        authors.add(new Author(3, "J.K.", "Rowling"));

        return authors;
    }
}
