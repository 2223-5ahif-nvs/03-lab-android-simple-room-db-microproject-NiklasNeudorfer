package at.htl.neudorfer.booksapp.model

import at.htl.neudorfer.booksapp.data.Author
import at.htl.neudorfer.booksapp.data.User
import at.htl.neudorfer.booksapp.model.db.dao.AuthorDao
import at.htl.neudorfer.booksapp.model.db.dao.UserDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

data class UserRepository @Inject constructor(
    private val userDao: UserDao
) {

    suspend fun insertUser(user: User) {
        userDao.insert(user)
    }

    suspend fun getAll(): Flow<List<User>> {
        return userDao.getAll()
    }

    suspend fun getByUsername(username: String): Flow<User?> {
        return userDao.findByUsername(username)
    }

    suspend fun deleteUser(user: User) {
        userDao.delete(user)
    }
}