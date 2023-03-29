package at.htl.neudorfer.booksapp.data

data class Book(
    val isLiked: Boolean,
    val imageIcon: String,

    val isbn: String,
    val title: String,
    val genre: Genre,
    val yearOfPublication: Int,

    val author: Author,
    val publisher: Publisher,

    // Image Urls
    val coverUrlSmall: String,
    val coverUrlMedium: String,
    val coverUrlLarge: String
)