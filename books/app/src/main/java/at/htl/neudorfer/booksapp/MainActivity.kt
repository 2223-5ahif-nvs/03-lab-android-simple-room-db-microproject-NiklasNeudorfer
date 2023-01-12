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

@Composable
fun Tabs() {
    var tabIndex by remember { mutableStateOf(0) } // 1.

    val tabTitles = listOf("Books", "Authors")
    Column { // 2.
        TabRow(selectedTabIndex = tabIndex) { // 3.
            tabTitles.forEachIndexed { index, title ->
                Tab(selected = tabIndex == index, // 4.
                    onClick = { tabIndex = index },
                    text = { Text(text = title) }) // 5.
            }
        }
        when (tabIndex) { // 6.
            0 -> BookList()
            1 -> AuthorsListScreen()
        }
    }
}