package at.htl.neudorfer.books.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import at.htl.neudorfer.books.utils.Constants.DATABASE_TABLE_BOOK

@Entity(tableName = DATABASE_TABLE_BOOK)
data class Book(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val genre: Genre
) {}