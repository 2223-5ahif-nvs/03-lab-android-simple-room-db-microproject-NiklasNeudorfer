package at.htl.neudorfer.books

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import at.htl.neudorfer.books.navigation.SetupNavigation
import at.htl.neudorfer.books.ui.SharedViewModel
import at.htl.neudorfer.books.ui.theme.BooksTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        val vm = SharedViewModel()

        super.onCreate(savedInstanceState)
        setContent {
            BooksTheme {
                navController = rememberNavController()
                SetupNavigation(navController = navController)
            }
        }
    }
}


@Composable
fun TodoView(vm: SharedViewModel) {

    LaunchedEffect(Unit, block = {
        vm.getAllBooks()
    })

    Scaffold(
        topBar = {
            TopBar()
        },
        content = {
            TodoList(vm = vm)
        }
    )
}

@Composable
private fun TodoList(vm: SharedViewModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        LazyColumn(modifier = Modifier.fillMaxHeight()) {
            items(vm.allBooks.value.size) { todo ->
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(0.dp, 0.dp, 16.dp, 0.dp)
                        ) {
                            Text(
                                todo.toString(),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                    Divider()
                }
            }
        }
    }
}

@Composable
private fun TopBar() {
    TopAppBar(
        title = {
            Row {
                Text("Todos")
            }
        })
}