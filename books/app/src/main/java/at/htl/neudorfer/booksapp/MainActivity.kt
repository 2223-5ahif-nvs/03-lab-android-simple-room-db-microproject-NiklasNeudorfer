package at.htl.neudorfer.booksapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import at.htl.neudorfer.booksapp.ui.authors.AuthorsListScreen
import at.htl.neudorfer.booksapp.ui.authors.AuthorsViewModel
import at.htl.neudorfer.booksapp.ui.books.BookList
import at.htl.neudorfer.booksapp.ui.favouriteAuthors.FavouriteAuthorsListScreen
import at.htl.neudorfer.booksapp.ui.profile.ProfileScreen
import at.htl.neudorfer.booksapp.ui.profile.ProfileViewModel
import at.htl.neudorfer.booksapp.ui.theme.BooksTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val authorVM: AuthorsViewModel by viewModels()
    private val profileVM: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BooksTheme {
                Tabs(authorVM, profileVM)
            }
        }
    }
}


// Source for the Tabs:
// https://www.rockandnull.com/jetpack-compose-swipe-pager/

@Composable
fun Tabs(
    authorsVM: AuthorsViewModel,
    profileVm: ProfileViewModel
) {
    var tabIndex by remember { mutableStateOf(0) }

    val tabTitles = listOf("Books", "Authors", "Liked", "Profile")
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
            1 -> AuthorsListScreen(authorsVM)
            2 -> FavouriteAuthorsListScreen(authorsVM)
            3 -> ProfileScreen(profileVm)
        }
    }
}