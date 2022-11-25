package at.htl.neudorfer.books.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import at.htl.neudorfer.books.navigation.destinations.bookComposable
import at.htl.neudorfer.books.navigation.destinations.booksListComposable
import at.htl.neudorfer.books.utils.Constants.BOOKS_LIST_SCREEN

@Composable
fun SetupNavigation(
    navController: NavHostController,
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(navController = navController,
        startDestination =  BOOKS_LIST_SCREEN) {

        booksListComposable(
            navigateToTaskScreen = screen.book
        )
        bookComposable (
            navigateToListkScreen = screen.bookList
        )

    }
}