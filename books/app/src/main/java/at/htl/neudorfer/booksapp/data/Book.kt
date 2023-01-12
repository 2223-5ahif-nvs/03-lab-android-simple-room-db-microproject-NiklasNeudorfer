package at.htl.neudorfer.booksapp.data

data class Book(
    val title: String,
    val description: String,
    val coverUrl: String,
    val genre: Genre,
    val author: Author
)