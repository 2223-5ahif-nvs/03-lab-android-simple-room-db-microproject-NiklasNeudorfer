package at.htl.neudorfer.booksapp.model

import at.htl.neudorfer.booksapp.data.Author
import at.htl.neudorfer.booksapp.model.api.ApiService
import at.htl.neudorfer.booksapp.model.db.dao.AuthorDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

data class AuthorsRepository @Inject constructor(
    private val authorDao: AuthorDao
) {
    // ----------------------------------------------------
    //      API ACCESS
    // ----------------------------------------------------

    private val apiService: ApiService = ApiService.getInstance()

    suspend fun getBookAuthors(): List<Author> {
        return apiService.getAuthors()
    }


    // ----------------------------------------------------
    //      DATABASE ACCESS
    // ----------------------------------------------------

    suspend fun insertAuthor(author: Author) {
        if (authorDao.findByName(author.fullName) == null) {
            authorDao.insert(author)
        }
    }

    fun getAllAuthorsFromDB(): Flow<List<Author>> {
        return authorDao.getAll()
    }

    suspend fun deleteAuthor(author: Author) {
        authorDao.delete(author)
    }

}
