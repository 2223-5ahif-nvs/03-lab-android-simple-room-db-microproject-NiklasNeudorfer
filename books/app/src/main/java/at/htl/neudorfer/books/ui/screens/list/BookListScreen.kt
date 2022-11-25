package at.htl.neudorfer.books.ui.screens.list

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BookListScreen(
    navigateToBookScreen: (bookId: Int) -> Unit
) {
    Scaffold(
        topBar = {
            BookListAppBar()
        },
        content = {},
        floatingActionButton = {
            ListFab(onFabClicked = navigateToBookScreen)
        }
    )

}

@Composable
fun ListFab(
    onFabClicked: (bookId: Int) -> Unit
) {
    FloatingActionButton(
        onClick = {
            onFabClicked(-1)
        },
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource(id = at.htl.neudorfer.books.R.string.add_button)
        )
    }
}

@Composable
@Preview
private fun ListScreenPreview() {
    BookListScreen(navigateToBookScreen = {})
}
