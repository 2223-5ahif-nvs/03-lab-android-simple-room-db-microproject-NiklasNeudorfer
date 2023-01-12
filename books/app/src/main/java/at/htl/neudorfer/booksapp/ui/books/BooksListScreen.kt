package at.htl.neudorfer.booksapp.ui.books

import android.util.Log
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import at.htl.neudorfer.booksapp.data.Author
import at.htl.neudorfer.booksapp.data.Book
import at.htl.neudorfer.booksapp.data.Genre
import at.htl.neudorfer.booksapp.ui.authors.AuthorItem
import at.htl.neudorfer.booksapp.ui.authors.AuthorsViewModel
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation


// PREVIEW for showing a simple BOOK ITEM
@Preview(showBackground = true)
@Composable
fun BookItemPreview() {
    val book = Book(
        "The Song of Ice and Fire",
        "It is a story of duplicity and treachery, nobility and honour, conquest and " +
                "triumph. In the frozen wastes to the north of Winterfell, sinister and supernatural " +
                "forces are mustering. At the centre of the conflict lie the Starks of Winterfell,...",
        "",
        Genre.FANTASY,
        Author("George R. R.", "Martin"),
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

                Image(
                    painter = rememberImagePainter(
                        data = book.coverUrl,

                        builder = {
                            scale(Scale.FILL)
                            //placeholder(R.drawable.placeholder)
                            transformations(CircleCropTransformation())
                        }
                    ),
                    contentDescription = "",
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
                    // make the text rounded
                    Text(
                        text = book.genre.name,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .background(
                                color = book.genre.color,
                                shape = RoundedCornerShape(4.dp)
                            )
                            .padding(4.dp)
                    )
                    Text(
                        text = book.description,
                        style = MaterialTheme.typography.body1,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                }
            }
        }
    }
}
