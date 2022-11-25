package at.htl.neudorfer.books.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import at.htl.neudorfer.books.data.models.Genre
import at.htl.neudorfer.books.ui.theme.GENRE_INDICATOR_SIZE
import at.htl.neudorfer.books.ui.theme.SMALL_PADDING

@Composable
fun GenreItem(genre: Genre) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Canvas(modifier = Modifier.size(GENRE_INDICATOR_SIZE)) {
            drawCircle(color = genre.color)
        }
        Text(
            modifier = Modifier.padding(start = SMALL_PADDING),
            text = genre.name,
            style = typography.subtitle1,
            color = MaterialTheme.colors.onSurface
        )
    }
}

@Composable
@Preview
fun GenreItemPreview() {
    GenreItem(genre = Genre.ROMANCE)
}