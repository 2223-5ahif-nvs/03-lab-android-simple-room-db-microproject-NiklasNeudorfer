package at.htl.neudorfer.boundary;

import at.htl.neudorfer.control.BookRepository;
import at.htl.neudorfer.entity.Book;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/book")
public class BookResource {

    @Inject
    BookRepository bookRepository;

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }

}
