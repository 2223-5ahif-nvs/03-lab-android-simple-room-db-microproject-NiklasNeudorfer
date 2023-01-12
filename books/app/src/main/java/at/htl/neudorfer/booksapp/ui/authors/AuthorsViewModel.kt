package at.htl.neudorfer.booksapp.ui.authors

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import at.htl.neudorfer.booksapp.data.Author
import at.htl.neudorfer.booksapp.model.BooksRepository
import kotlinx.coroutines.launch

class AuthorsViewModel(
    private val booksRepository: BooksRepository = BooksRepository()
): ViewModel() {
    val TAG = AuthorsViewModel::class.java.name;

    init {
        viewModelScope.launch {
            val authors = getAuthors()
            Log.d(TAG, "Authors: $authors")
            authorsState.value = authors
        }
    }

    val authorsState: MutableState<List<Author>> = mutableStateOf((emptyList<Author>()))

    private suspend fun getAuthors():List<Author> {
        return booksRepository.getBookAuthors();
    }
}