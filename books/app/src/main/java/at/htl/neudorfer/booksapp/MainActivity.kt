package at.htl.neudorfer.booksapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import at.htl.neudorfer.booksapp.data.Book
import at.htl.neudorfer.booksapp.ui.authors.AuthorsListScreen
import at.htl.neudorfer.booksapp.ui.books.BookList
import at.htl.neudorfer.booksapp.ui.books.BooksViewModel
import at.htl.neudorfer.booksapp.ui.theme.BooksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BooksTheme {
                Tabs()
            }
        }
    }
}


// Source for the Tabs:
// https://www.rockandnull.com/jetpack-compose-swipe-pager/

@Composable
fun Tabs() {
    var tabIndex by remember { mutableStateOf(0) }

    val tabTitles = listOf("Books", "Authors")
    Column {
        TabRow(selectedTabIndex = tabIndex) {
            tabTitles.forEachIndexed { index, title ->
                Tab(selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    text = { Text(text = title) })
            }
        }
        when (tabIndex) {
            0 -> BookList()
            1 -> AuthorsListScreen()
        }
    }
}