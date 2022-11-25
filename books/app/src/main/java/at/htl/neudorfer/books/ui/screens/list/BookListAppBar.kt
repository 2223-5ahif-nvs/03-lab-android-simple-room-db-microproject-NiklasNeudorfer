package at.htl.neudorfer.books.ui.screens.list

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import at.htl.neudorfer.books.data.models.Genre
import at.htl.neudorfer.books.ui.theme.topAppBarBackground
import at.htl.neudorfer.books.ui.theme.topAppBarColor

@Composable
fun BookListAppBar() {
    DefaultListAppBar(
        onSearchClicked = {}
    )
}

@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Book List",
                color = MaterialTheme.colors.topAppBarColor
            )
        },
        actions = {
            BookListAppBarActions(onSearchClicked = onSearchClicked)
        },

        backgroundColor = MaterialTheme.colors.topAppBarBackground
    )
}

@Composable
fun BookListAppBarActions(
    onSearchClicked: () -> Unit
) {
    BookSearchAction(onSearchClicked = onSearchClicked)
}


@Composable
fun BookSearchAction(
    onSearchClicked: () -> Unit
) {
    IconButton(onClick = { onSearchClicked() }) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = stringResource(id = at.htl.neudorfer.books.R.string.search_button),
            tint = MaterialTheme.colors.topAppBarColor
        )

    }
}

@Composable
fun SortBookAction(
    onSearchClicked: (Genre) -> Unit
){

}


@Composable
@Preview
private fun ListAppBarPreview() {
    DefaultListAppBar(
        onSearchClicked = {}
    )
}
