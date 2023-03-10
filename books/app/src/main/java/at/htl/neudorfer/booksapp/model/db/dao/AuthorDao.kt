package at.htl.neudorfer.booksapp.model.db.dao

import androidx.room.*
import at.htl.neudorfer.booksapp.data.Author
import kotlinx.coroutines.flow.Flow

@Dao
interface AuthorDao {

    @Query("SELECT * FROM authors")
    fun getAll(): Flow<List<Author>>

    @Query("SELECT * FROM AUTHORS WHERE id = :authorId")
    fun getById(authorId: Int): Flow<Author>

    @Query("SELECT * FROM authors WHERE full_name LIKE :fullName LIMIT 1")
    fun findByName(fullName: String): Author?



    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(author: Author)

    @Insert
    suspend fun insertMultiple(vararg authors: Author)
    @Insert
    suspend fun insertAll(authors: List<Author>)


    @Delete
    suspend fun delete(author: Author)

    //@Query("DELETE FROM authors")
    //fun nukeTable()
}