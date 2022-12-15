package at.htl.neudorfer.books.data

data class Book(
    val title: String,
    val description: String,
    val genre: Genre,
    val author: Author
)