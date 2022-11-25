package at.htl.neudorfer.books.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import at.htl.neudorfer.books.utils.Constants
import at.htl.neudorfer.books.utils.Constants.BOOKS_LIST_ARGUMENT_KEY

fun NavGraphBuilder.booksListComposable(
    navigateToTaskScreen: (Int) -> Unit
){
    composable(
        route = Constants.BOOKS_LIST_SCREEN,
        arguments = listOf(navArgument(BOOKS_LIST_ARGUMENT_KEY){
            type = NavType.StringType
        })
    ){

    }
}