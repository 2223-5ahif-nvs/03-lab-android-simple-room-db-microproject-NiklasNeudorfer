package at.htl.neudorfer.booksapp.ui.profile

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import at.htl.neudorfer.booksapp.R
import at.htl.neudorfer.booksapp.data.User
import coil.compose.AsyncImage
import coil.request.ImageRequest
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.zIndex

@Composable
fun ProfileScreen(viewModel: ProfileViewModel) {
    val users = viewModel.users
    var profilePic by remember { mutableStateOf(1) }
    var currentUsername by remember { mutableStateOf("") }
    var editMode by remember { mutableStateOf(false) }

    if (users.size == 0) {
        Button(
            onClick = { viewModel.addUser(User("admin", profilePicture = 1, admin = true)) }) {
            Text(text = "Create User")
        }
    } else {
        profilePic = users[0].profilePicture
    }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Card(
            //border = BorderStroke(1.dp, Color.Black),
            elevation = 40.dp,
            modifier = Modifier
                .padding(10.dp, 0.dp, 10.dp, 0.dp)
                .height((LocalConfiguration.current.screenHeightDp / 5).dp)
                .width((LocalConfiguration.current.screenWidthDp / 2.5).dp),
            shape = RoundedCornerShape(40.dp)
        ) {

            Row(verticalAlignment = Alignment.Top) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("http://10.0.2.2:8080/imgs/profile_placeholder_" + profilePic + ".png")
                        .crossfade(true)
                        .build(),
                    contentDescription = "Book Cover from ${users[0].name}",
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
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row() {
                    Column() {
                        Button(enabled = profilePic > 1 && editMode, onClick = { profilePic--; }) {
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
                        Button(enabled = profilePic < 10 && editMode, onClick = { profilePic++ }) {
                            Text(text = ">")
                        }
                    }
                }

                Row {
                    Text(
                        modifier = Modifier.padding(0.dp, 50.dp, 0.dp, 20.dp),
                        text = "" + users[0].name,
                        style = MaterialTheme.typography.h3,
                        maxLines = 1
                    )
                    IconButton(
                        onClick = { editMode = true },
                        modifier = Modifier.padding(0.dp, 60.dp, 0.dp, 20.dp),
                    ) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit Profile")
                    }
                }

                if (editMode) {
                    Row {
                        OutlinedTextField(
                            value = currentUsername,
                            onValueChange = { newText ->
                                currentUsername = newText
                            },
                            label = { Text(text = "Username") },
                            modifier = Modifier
                                .width((LocalConfiguration.current.screenWidthDp / 2).dp),
                            placeholder = { Text(text = "e.g. ILikeReading123") },
                        )
                    }

                    Row {
                        Button(onClick = {
                            editMode= false

                            viewModel.updateUser(
                                users[0],
                                currentUsername,
                                profilePic
                            )
                        }) {
                            Text(text = "Save")
                        }
                    }
                }
            }
        }
    }
}