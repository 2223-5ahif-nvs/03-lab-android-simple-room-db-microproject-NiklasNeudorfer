package at.htl.neudorfer.booksapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @ColumnInfo(name = "username") val name: String,
    @PrimaryKey(autoGenerate = true) val id: Int? = -1,
    @ColumnInfo(name = "profile_picture") val profilePicture: Int,
    @ColumnInfo(name = "is_admin") val admin: Boolean
)