package at.htl.neudorfer.boundary;

import at.htl.neudorfer.control.AuthorRepository;
import at.htl.neudorfer.entity.Author;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/author")
public class AuthorResource {

    @Inject
    AuthorRepository authorRepository;

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> getAllAuthors(){
        return authorRepository.getAllAuthors();
    }

}
