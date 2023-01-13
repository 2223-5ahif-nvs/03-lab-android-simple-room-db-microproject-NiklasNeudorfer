package at.htl.neudorfer.booksapp.ui.books

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import at.htl.neudorfer.booksapp.data.Author
import at.htl.neudorfer.booksapp.data.Book
import at.htl.neudorfer.booksapp.data.Genre
import at.htl.neudorfer.booksapp.data.Publisher
import coil.compose.AsyncImage
import at.htl.neudorfer.booksapp.R


// PREVIEW for showing a simple BOOK ITEM
@Preview(showBackground = true)
@Composable
fun BookItemPreview() {
    val book = Book(
        "1",
        "The Lord of the Rings",
        Genre.FANTASY,
        1954,
        Author("J. R. R. Tolkien"),
        Publisher("Allen & Unwin"),
        "https://images-na.ssl-images-amazon.com/images/I/51Zt3uZJFJL._SX331_BO1,204,203,200_.jpg",
        "https://www.amazon.com/Lord-Rings-1-J-R-Tolkien/dp/0618260307",
        "https://www.goodreads.com/book/show/33.The_Lord_of_the_Rings"
    )
    BookItem(book = book)
}

// List of BOOK ITEMS gets displayed
@Composable
fun BookList() {
    val viewModel: BooksViewModel = viewModel();
    viewModel.getBookList()
    val bookList = viewModel.bookListResponse;


    Log.d("BookList", "BookList: $bookList")

    LazyColumn {
        itemsIndexed(items = bookList) { index, item ->
            BookItem(book = item)
        }
    }
}

// A CONTAINER FOR ONE BOOK
// where Genre, Cover, short description get displayed
@Composable
fun BookItem(book: Book) {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp
    ) {
        Surface() {

            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {

                AsyncImage(
                    model = book.coverUrlSmall, // TODO not working at the moment
                    contentDescription = "Book Cover from ${book.title} by ${book.author.fullName}",
                    error = painterResource(R.drawable.bookmark),
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.2f)
                )


                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = book.title,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )
                    // TODO save data in backend to db so that the Genre doesn't change ever second
//                    Text(
//                        text = book.genre.name,
//                        style = MaterialTheme.typography.caption,
//                        modifier = Modifier
//                            .background(
//                                color = book.genre.color,
//                                shape = RoundedCornerShape(4.dp)
//                            )
//                            .padding(4.dp)
//                    )
                    Text(
                        text = "by " + book.author.fullName,
                        style = MaterialTheme.typography.body1,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                }
            }
        }
    }
}
