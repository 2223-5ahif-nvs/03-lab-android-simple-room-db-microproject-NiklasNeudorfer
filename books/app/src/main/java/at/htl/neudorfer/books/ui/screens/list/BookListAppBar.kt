package at.htl.neudorfer.books.ui.screens.list

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BookListAppBar(){
    DefaultListAppBar()
}

@Composable
fun DefaultListAppBar(){
    TopAppBar(
        title = {
            Text(text = "Book List")
        },
        backgroundColor = MaterialTheme.colors.primary
    )
}

@Composable
@Preview
private fun DefaultListAppBarPreview(){
    DefaultListAppBar();
}