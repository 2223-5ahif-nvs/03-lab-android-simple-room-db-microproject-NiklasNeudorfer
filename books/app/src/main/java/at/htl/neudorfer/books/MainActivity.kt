package at.htl.neudorfer.books

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import at.htl.neudorfer.books.data.Author
import at.htl.neudorfer.books.data.Book
import at.htl.neudorfer.books.data.Genre
import at.htl.neudorfer.books.ui.theme.BooksTheme
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation

class MainActivity : ComponentActivity() {
    val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BooksTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //MovieList(movieList = mainViewModel.movieListResponse)
                    mainViewModel.getBookList()
                }
            }
        }
    }
}

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
                        data = "https://howtodoandroid.com/images/coco.jpg",

                        builder = {
                            scale(coil.size.Scale.FILL)
                            placeholder(R.drawable.placeholder)
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

@Preview(showBackground = true)
@Composable
fun BookItemPreview() {
    val book = Book(
        "The Song of Ice and Fire",
        "It is a story of duplicity and treachery, nobility and honour, conquest and " +
                "triumph. In the frozen wastes to the north of Winterfell, sinister and supernatural " +
                "forces are mustering. At the centre of the conflict lie the Starks of Winterfell,...",
        Genre.FANTASY,
        Author("George R. R.", "Martin"),
    )
    BookItem(book = book)
}