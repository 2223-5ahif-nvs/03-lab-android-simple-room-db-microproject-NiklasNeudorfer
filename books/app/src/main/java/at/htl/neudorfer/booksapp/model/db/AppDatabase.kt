package at.htl.neudorfer.booksapp.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import at.htl.neudorfer.booksapp.data.Author
import at.htl.neudorfer.booksapp.model.db.dao.AuthorDao

@Database(entities = [Author::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun authorDao(): AuthorDao
}