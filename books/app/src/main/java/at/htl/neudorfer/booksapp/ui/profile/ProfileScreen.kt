package at.htl.neudorfer.booksapp.ui.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import at.htl.neudorfer.booksapp.R
import at.htl.neudorfer.booksapp.data.User
import at.htl.neudorfer.booksapp.ui.favouriteAuthors.FavouriteAuthorItem
import at.htl.neudorfer.booksapp.ui.favouriteAuthors.FavouriteAuthorsViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.zIndex

@Composable
fun ProfileScreen(viewModel: ProfileViewModel) {
    val users = viewModel.users
    var profilePic by remember { mutableStateOf(1) }

    if (users.size == 0) {
        Button(
            onClick = { viewModel.addUser(User("admin", profilePicture = 1, admin = true)) }) {
            Text(text = "Create User")
        }
    }


    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
    ) {
        items(users) { user ->

            Card(
                //border = BorderStroke(1.dp, Color.Black),
                elevation = 40.dp,
                modifier = Modifier
                    .padding(10.dp, 0.dp, 10.dp, 0.dp),
                shape = RoundedCornerShape(40.dp)
            ) {

                Row(verticalAlignment = Alignment.Top) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("http://10.0.2.2:8080/imgs/profile_placeholder_" + profilePic.toString() + ".png")
                            .crossfade(true)
                            .build(),
                        contentDescription = "Book Cover from ${user.name}",
                        error = painterResource(R.drawable.placeholder),
                        modifier = Modifier
                            .fillMaxHeight()
                    )
                }
            }

            Card(
                shape = RoundedCornerShape(40.dp),
                elevation = 15.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(0.dp)
                //.zIndex(100f)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row() {
                        Column() {
                            Button(enabled = profilePic > 1, onClick = { profilePic--; }) {
                                Text(text = "<")
                            }
                        }

                        Column() {
                            Text(
                                text = profilePic.toString(),
                                modifier = Modifier.padding(20.dp, 10.dp, 20.dp, 10.dp)
                            )
                        }

                        Column() {
                            Button(enabled = profilePic < 10, onClick = { profilePic++ }) {
                                Text(text = ">")
                            }
                        }
                    }
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(0.dp, 50.dp, 0.dp, 20.dp),
                        text = "" + user.name,
                        style = MaterialTheme.typography.h3,
                        maxLines = 1
                    )
                }
            }

        }
    }
}