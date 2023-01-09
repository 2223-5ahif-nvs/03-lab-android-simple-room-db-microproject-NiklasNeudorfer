package at.htl.neudorfer.books.data.repositories

import at.htl.neudorfer.books.data.BookDao
import at.htl.neudorfer.books.data.models.Book
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class BookRepository @Inject constructor(private val bookDao: BookDao) {

    val getAllBooks: Flow<List<Book>> = bookDao.getAllBooks()

    fun getSelectedBook(bookId: Int): Flow<Book> {
        return bookDao.getSelectedBook(bookId = bookId)
    }

    suspend fun addBook(b: Book) {
        bookDao.addBook(book = b)
    }

    suspend fun updateBook(b: Book) {
        bookDao.updateBook(book = b)
    }

    suspend fun deleteBook(b: Book) {
        bookDao.deleteBook(book = b)
    }

    suspend fun deleteAllBooks() {
        bookDao.deleteAllBooks()
    }

    fun searchBookByTitle(title: String): Flow<List<Book>> {
        return bookDao.searchBookByTitle(title = title)
    }

}