package at.htl.neudorfer.books.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import at.htl.neudorfer.books.data.models.Genre
import at.htl.neudorfer.books.utils.Action
import at.htl.neudorfer.books.utils.Constants.BOOK_ARGUMENT_KEY
import at.htl.neudorfer.books.utils.Constants.BOOK_SCREEN

fun NavGraphBuilder.bookComposable(
    navigateToListkScreen: (Action) -> Unit
){
    composable(
        route = BOOK_SCREEN,
        arguments = listOf(navArgument(BOOK_ARGUMENT_KEY){
            type = NavType.IntType
        })
    ){

    }
}