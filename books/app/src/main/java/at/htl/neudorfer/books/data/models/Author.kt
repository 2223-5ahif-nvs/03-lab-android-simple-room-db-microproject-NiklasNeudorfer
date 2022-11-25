package at.htl.neudorfer.books.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "author")
data class Author(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val firstName: String,
    val lastName: String
)
{}