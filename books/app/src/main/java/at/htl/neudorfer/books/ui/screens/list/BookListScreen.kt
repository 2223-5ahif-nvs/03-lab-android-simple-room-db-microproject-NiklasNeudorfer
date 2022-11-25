package at.htl.neudorfer.books.ui.screens.list

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

fun BookListScreen (
    navigateToBookScreen: (Int) -> Unit
) {

}

@Composable
@Preview
private fun ListScreenPreview(){
    BookListScreen(navigateToBookScreen = {})
}