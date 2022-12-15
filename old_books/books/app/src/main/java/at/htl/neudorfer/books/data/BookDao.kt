package at.htl.neudorfer.books.data

import androidx.room.*
import at.htl.neudorfer.books.data.models.Book
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Query("SELECT * FROM book ORDER BY id ASC")
    fun getAllBooks(): Flow<List<Book>>

    @Query("SELECT * FROM book WHERE id=:bookId")
    fun getSelectedBook(bookId: Int) : Flow<Book>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addBook(book: Book)

    @Update
    suspend fun updateBook(book: Book)

    @Delete
    suspend fun deleteBook(book: Book)

    @Query("DELETE FROM book")
    suspend fun deleteAllBooks()

    @Query("SELECT * FROM book WHERE title LIKE :title")
    fun searchBookByTitle(title: String): Flow<List<Book>>
}