package at.htl.neudorfer.books.data

import androidx.room.*
import at.htl.neudorfer.books.data.models.Author
import kotlinx.coroutines.flow.Flow

@Dao
interface AuthorDao {

    @Query("SELECT * FROM author ORDER BY id ASC")
    fun getAllAuthors(): Flow<List<Author>>

    @Query("SELECT * FROM author WHERE id=:authorId")
    fun getSelectedAuthor(authorId: Int) : Flow<Author>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAuthor(author: Author)

    @Update
    suspend fun updateAuthor(author: Author)

    @Delete
    suspend fun deleteAuthor(author: Author)

    @Query("DELETE FROM author")
    suspend fun deleteAllAuthors()

    @Query("SELECT * FROM author WHERE lastName LIKE :lastName")
    fun searchAuhtorByLastName(lastName: String): Flow<List<Author>>
}