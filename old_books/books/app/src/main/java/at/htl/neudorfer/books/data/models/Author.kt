package at.htl.neudorfer.books.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import at.htl.neudorfer.books.utils.Constants

@Entity(tableName = Constants.DATABASE_TABLE_AUHTOR)
data class Author(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val firstName: String,
    val lastName: String
)
{}