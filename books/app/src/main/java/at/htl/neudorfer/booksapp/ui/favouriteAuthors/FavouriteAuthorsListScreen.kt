package at.htl.neudorfer.booksapp.ui.favouriteAuthors

import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import at.htl.neudorfer.booksapp.data.Author
import at.htl.neudorfer.booksapp.ui.authors.AuthorsViewModel
import at.htl.neudorfer.booksapp.ui.profile.ProfileViewModel


@OptIn(ExperimentalTextApi::class)
@Composable
fun FavouriteAuthorsListScreen(viewModel: AuthorsViewModel, userVM: ProfileViewModel) {
    val authors = viewModel.authorsStateDB.value
    var username by remember { mutableStateOf("Your") }

    if (userVM.users.size > 0){
        username = userVM.users[0].name
    }

    Text(
        text = username + "'s likes:",
        fontStyle = MaterialTheme.typography.h1.fontStyle,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily.SansSerif,
        fontSize = 30.sp,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    )
    Divider(
        startIndent = 8.dp,
        thickness = 1.dp,
        color = Color.Gray
    )
    LazyColumn {

        items(authors) { author ->
            FavouriteAuthorItem(author, viewModel)
        }
    }
}

@Composable
fun FavouriteAuthorItem(author: Author, viewModel: AuthorsViewModel) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            ) {
                Text(text = author.fullName)
            }
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                OutlinedButton(
                    onClick = { viewModel.deleteAuthor(author) }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = null,
                        tint = Color.Red
                    )
                }
            }
        }
    }
}