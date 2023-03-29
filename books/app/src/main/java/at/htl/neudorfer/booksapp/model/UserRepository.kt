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
        if (userDao.findByUsername(user.name) == null) {
            userDao.insert(user)
        }
    }

    suspend fun getAllAuthorsFromDB(): Flow<List<User>> {
        return userDao.getAll()
    }

    suspend fun deleteAuthor(user: User) {
        userDao.delete(user)
    }
}