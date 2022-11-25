package at.htl.neudorfer.books.data

import androidx.room.Database
import at.htl.neudorfer.books.data.models.Author
import at.htl.neudorfer.books.data.models.Book


@Database(entities = [Author::class, Book::class], version = 1, exportSchema = false)
abstract class LibraryDatabase {

    abstract fun authorDao(): AuthorDao

    abstract fun bookDao(): BookDao
}