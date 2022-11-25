package at.htl.neudorfer.books.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
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

@Composable
fun GenreItem(genre: Genre) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Canvas(modifier = Modifier.size(16.dp)) {
            drawCircle(color = genre.color)
        }
        Text(
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