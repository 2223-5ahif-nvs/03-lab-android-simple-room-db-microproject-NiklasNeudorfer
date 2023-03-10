package at.htl.neudorfer.booksapp.ui.favouriteAuthors

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import at.htl.neudorfer.booksapp.data.Author


@OptIn(ExperimentalTextApi::class)
@Composable
fun FavouriteAuthorsListScreen(viewModel: FavouriteAuthorsViewModel) {
    val authors = viewModel.authors

    //val gradientColors = listOf(Color.Cyan, Color.Blue, Color.Magenta)


    Text(
        text = "Your likes:",
        fontStyle = MaterialTheme.typography.h1.fontStyle,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily.SansSerif,
        fontSize = 30.sp,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
        /*
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = gradientColors
            )
        )
         */
    )
    Divider(
        startIndent = 8.dp,
        thickness = 1.dp,
        color = Color.Gray
    )
    LazyColumn {

        items(authors) { author ->
            FavouriteAuthorItem(author)
        }
    }
}

@Composable
fun FavouriteAuthorItem(author: Author) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Row {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            ) {
                Text(text = author.fullName)
            }
        }
    }
}