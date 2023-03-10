package at.htl.neudorfer.booksapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "authors")
data class Author(

    // use int vs UUID for PK
    // https://stackoverflow.com/questions/59572749/using-uuid-for-primary-key-using-room-with-android

    @ColumnInfo(name = "full_name") val fullName: String,
    @PrimaryKey(autoGenerate = true) val id: Int ? = -1
)