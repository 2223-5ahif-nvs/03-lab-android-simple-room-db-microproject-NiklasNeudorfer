package at.htl.neudorfer.books.navigation

import androidx.navigation.NavHostController
import at.htl.neudorfer.books.utils.Action
import at.htl.neudorfer.books.utils.Constants.BOOKS_LIST_SCREEN

class Screens(navController: NavHostController) {

    val bookList: (Action) -> Unit = { action ->
        navController.navigate("books/${action.name}"){
            popUpTo(BOOKS_LIST_SCREEN) { inclusive = true }
            launchSingleTop = true
        }
    }
    val book: (Int) -> Unit = { bookId ->
        navController.navigate("book/$bookId")
    }
}