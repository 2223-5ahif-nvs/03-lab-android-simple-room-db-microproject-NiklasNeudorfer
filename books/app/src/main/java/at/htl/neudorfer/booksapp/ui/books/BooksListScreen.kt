package at.htl.neudorfer.booksapp.ui.books

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import at.htl.neudorfer.booksapp.R
import at.htl.neudorfer.booksapp.data.Author
import at.htl.neudorfer.booksapp.data.Book
import at.htl.neudorfer.booksapp.data.Genre
import at.htl.neudorfer.booksapp.data.Publisher
import coil.compose.AsyncImage
import coil.request.ImageRequest


// PREVIEW for showing a simple BOOK ITEM
@Preview(showBackground = true)
@Composable
fun BookItemPreview() {
    val book = Book(
        false,
        "3",
        "1",
        "The Lord of the Rings",
        Genre.FANTASY,
        1954,
        Author("J. R. R. Tolkien"),
        Publisher("Allen & Unwin"),
        "https://www.pngmart.com/files/16/Electric-Chainsaw-PNG-Transparent-Image.png",
        "https://www.pngmart.com/files/16/Electric-Chainsaw-PNG-Transparent-Image.png",
        "https://www.pngmart.com/files/16/Electric-Chainsaw-PNG-Transparent-Image.png"
    )
    BookItem(book = book)
}

// List of BOOK ITEMS gets displayed
@Composable
fun BookList() {
    val viewModel: BooksViewModel = viewModel();
    val bookList = viewModel.booksState.value

    LazyColumn {
        itemsIndexed(items = bookList) { _, item ->
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
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("http://10.0.2.2:8080/imgs/book_placeholder_"+ (1..10).random() +".png")
                        .crossfade(true)
                        .build(), // TODO not working at the moment
                    contentDescription = "Book Cover from ${book.title} by ${book.author.fullName}",
                    error = painterResource(R.drawable.placeholder),
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
