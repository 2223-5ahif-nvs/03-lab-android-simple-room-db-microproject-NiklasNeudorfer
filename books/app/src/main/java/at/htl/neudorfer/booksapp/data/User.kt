package at.htl.neudorfer.booksapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @ColumnInfo(name = "username") var name: String,
    @PrimaryKey(autoGenerate = true) var id: Int? = -1,
    @ColumnInfo(name = "profile_picture") var profilePicture: Int,
    @ColumnInfo(name = "is_admin") var admin: Boolean
)