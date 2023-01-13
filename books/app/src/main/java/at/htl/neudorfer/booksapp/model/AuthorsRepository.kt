package at.htl.neudorfer.booksapp.model

import at.htl.neudorfer.booksapp.data.Author
import at.htl.neudorfer.booksapp.model.api.ApiService

data class AuthorsRepository(
    private val apiService: ApiService = ApiService.getInstance()
) {
    suspend fun getBookAuthors(): List<Author> {
        return apiService.getAuthors()
    }
}
