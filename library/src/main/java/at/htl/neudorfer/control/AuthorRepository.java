package at.htl.neudorfer.control;

import at.htl.neudorfer.entity.Author;
import at.htl.neudorfer.entity.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class AuthorRepository {

    @Inject
    BookRepository bookRepository;

    public List<Author> getAllAuthors(){
        return bookRepository.getAllBooks().stream().map(Book::getAuthor).distinct().toList();
    }
}
