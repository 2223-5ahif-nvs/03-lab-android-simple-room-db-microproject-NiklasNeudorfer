package at.htl.neudorfer.books.data.repositories

import at.htl.neudorfer.books.data.AuthorDao
import at.htl.neudorfer.books.data.BookDao
import at.htl.neudorfer.books.data.models.Author
import at.htl.neudorfer.books.data.models.Book
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class AuthorRepository @Inject constructor(private val authorDao: AuthorDao) {

    val getAllAuthors: Flow<List<Author>> = authorDao.getAllAuthors()

    fun getSelectedAuthor(authorId: Int): Flow<Author> {
        return authorDao.getSelectedAuthor(authorId = authorId)
    }

    suspend fun addAuthor(a: Author) {
        authorDao.addAuthor(author = a)
    }

    suspend fun updateAuthor(a: Author) {
        authorDao.updateAuthor(author = a)
    }

    suspend fun deleteAuthor(a: Author) {
        authorDao.deleteAuthor(author = a)
    }

    suspend fun deleteAllAuthors() {
        authorDao.deleteAllAuthors()
    }

    fun searchAuthorByName(lastName: String): Flow<List<Author>> {
        return authorDao.searchAuhtorByLastName(lastName = lastName)
    }

}