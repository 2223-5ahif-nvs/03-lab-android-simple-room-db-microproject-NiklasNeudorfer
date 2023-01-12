package at.htl.neudorfer.booksapp.model

import at.htl.neudorfer.booksapp.data.Author
import at.htl.neudorfer.booksapp.data.Book
import at.htl.neudorfer.booksapp.model.api.ApiService

class BooksRepository(
    private val apiService: ApiService = ApiService.getInstance()
) {
    suspend fun getBooks() : List<Book> {
        return apiService.getBooks();
    }

    suspend fun getBookAuthors() : List<Author> {
        return this.getBooks().map { it.author }
    }
}