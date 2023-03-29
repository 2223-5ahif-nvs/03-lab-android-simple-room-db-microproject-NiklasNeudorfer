package at.htl.neudorfer.booksapp.ui.profile

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import at.htl.neudorfer.booksapp.data.User
import at.htl.neudorfer.booksapp.ui.favouriteAuthors.FavouriteAuthorItem
import at.htl.neudorfer.booksapp.ui.favouriteAuthors.FavouriteAuthorsViewModel

@Composable
fun ProfileScreen(viewModel: ProfileViewModel) {
    val users = viewModel.users

    LazyColumn {

        items(users) { user ->
            if (user == null){
                Text(text = "User NULL")
            } else {
                Text(text = user.name)
            }
            Button(onClick = {viewModel.addUser(User("admin", profilePicture = "1"))}) {
                Text(text = "add admin")

            }
        }
    }
}