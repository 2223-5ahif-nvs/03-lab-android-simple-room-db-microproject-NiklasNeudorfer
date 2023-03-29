package at.htl.neudorfer.booksapp.model.db.dao

import androidx.room.*
import at.htl.neudorfer.booksapp.data.Author
import at.htl.neudorfer.booksapp.data.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): Flow<List<User>>

    @Query("SELECT * FROM user WHERE id = :userId")
    fun getById(userId: Int): Flow<User>

    @Query("SELECT * FROM user WHERE username LIKE :uname LIMIT 1")
    fun findByUsername(uname: String): Flow<User?>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User)

    @Insert
    suspend fun insertMultiple(vararg users: User)
    @Insert
    suspend fun insertAll(users: List<User>)


    @Delete
    suspend fun delete(author: User)

    //@Query("DELETE FROM users")
    //fun nukeTable()
}