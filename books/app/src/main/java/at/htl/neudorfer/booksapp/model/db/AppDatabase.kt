package at.htl.neudorfer.booksapp.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import at.htl.neudorfer.booksapp.data.Author
import at.htl.neudorfer.booksapp.data.User
import at.htl.neudorfer.booksapp.model.db.dao.AuthorDao
import at.htl.neudorfer.booksapp.model.db.dao.UserDao

@Database(entities = [Author::class, User::class], version = 5, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun authorDao(): AuthorDao

    abstract fun userDao(): UserDao
}