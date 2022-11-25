package at.htl.neudorfer.books.ui.screens.list

import androidx.compose.foundation.layout.padding
import at.htl.neudorfer.books.R
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import at.htl.neudorfer.books.data.models.Genre
import at.htl.neudorfer.books.ui.theme.topAppBarBackground
import at.htl.neudorfer.books.ui.theme.topAppBarColor
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import at.htl.neudorfer.books.components.GenreItem
import at.htl.neudorfer.books.ui.theme.LARGE_PADDING
import at.htl.neudorfer.books.ui.theme.topAppBarContentColor
import kotlin.text.Typography

@Composable
fun BookListAppBar() {
    DefaultListAppBar(
        onSearchClicked = {},
        onSortClicked = {},
        onDeleteClicked = {}
    )
}

@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Genre) -> Unit,
    onDeleteClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Book List",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        actions = {
            BookListAppBarActions(
                onSearchClicked = onSearchClicked,
                onSortClicked = onSortClicked,
                onDeleteClicked = onDeleteClicked
            )
        },

        backgroundColor = MaterialTheme.colors.topAppBarBackground
    )
}

@Composable
fun BookListAppBarActions(
    onSearchClicked: () -> Unit,
    onSortClicked: (Genre) -> Unit,
    onDeleteClicked: () -> Unit
) {
    BookSearchAction(onSearchClicked = onSearchClicked)
    SortBookAction(onSortClicked = onSortClicked)
    DeleteAllAction(onDeleteClicked = onDeleteClicked)
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
    onSortClicked: (Genre) -> Unit
) {
    var expaned by remember { mutableStateOf(false) }

    IconButton(onClick = { expaned = true }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter_list),
            contentDescription = stringResource(id = R.string.sort_action),
            tint = MaterialTheme.colors.topAppBarColor
        )

        DropdownMenu(
            expanded = expaned,
            onDismissRequest = { expaned = false }
        ) {

            enumValues<Genre>().forEach() {
                DropdownMenuItem(onClick = {
                    onSortClicked(it)
                    expaned = false
                }) {
                    GenreItem(genre = it)
                }
            }
        }
    }
}

@Composable
fun DeleteAllAction(
    onDeleteClicked: () -> Unit
){
    var expanded by remember { mutableStateOf(false)}

    IconButton(
        onClick = { expanded = true }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_more_vert_24),
            contentDescription = stringResource(id = R.string.delete_all_action),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                onClick = { 
                    expanded = false 
                    onDeleteClicked() 
                }
            ) {
                Text(
                    //modifier = Modifier.padding(start = LARGE_PADDING),
                    text = stringResource(id = R.string.delete_all_action),
                    style = typography.subtitle2

                )
            }

        }

    }
}


@Composable
@Preview
private fun ListAppBarPreview() {
    DefaultListAppBar(
        onSearchClicked = {},
        onSortClicked = {},
        onDeleteClicked = {}
    )
}
