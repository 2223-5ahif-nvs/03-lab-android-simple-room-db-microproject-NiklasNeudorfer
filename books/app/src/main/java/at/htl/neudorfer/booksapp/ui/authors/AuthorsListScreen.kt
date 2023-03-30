package at.htl.neudorfer.booksapp.ui.authors

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import at.htl.neudorfer.booksapp.data.Author


@Composable
fun AuthorsListScreen(viewModel: AuthorsViewModel) {
    val authors = viewModel.authorsState.value

    LazyColumn() {
        items(authors) { author ->
            AuthorItem(author, viewModel)
        }
    }

}

@Composable
fun AuthorItem(author: Author, viewModel: AuthorsViewModel) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            ) {
                Text(text = author.fullName)
            }

            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                OutlinedButton(
                    onClick = { viewModel.addAuthor(author) }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = null,
                        tint = Color.Yellow
                    )
                    Text("Like")
                }
            }
        }
    }
}
