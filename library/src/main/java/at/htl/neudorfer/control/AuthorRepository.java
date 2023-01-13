package at.htl.neudorfer.control;

import at.htl.neudorfer.entity.Author;
import at.htl.neudorfer.entity.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class AuthorRepository {

    @Inject
    BookRepository bookRepository;

    public Set<Author> getAllAuthors(){
        return bookRepository.getAllBooks().stream().map(Book::getAuthor).collect(Collectors.toSet());
    }
}
