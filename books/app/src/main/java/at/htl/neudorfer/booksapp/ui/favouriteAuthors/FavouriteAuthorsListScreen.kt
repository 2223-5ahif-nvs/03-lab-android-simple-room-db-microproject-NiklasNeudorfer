package at.htl.neudorfer.booksapp.ui.favouriteAuthors

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import at.htl.neudorfer.booksapp.data.Author


@Composable
fun FavouriteAuthorsListScreen(viewModel: FavouriteAuthorsViewModel) {
    val authors = viewModel.authors

    LazyColumn() {
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