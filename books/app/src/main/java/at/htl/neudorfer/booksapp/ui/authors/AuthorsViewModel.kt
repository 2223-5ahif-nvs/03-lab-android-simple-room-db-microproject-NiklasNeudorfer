package at.htl.neudorfer.booksapp.ui.authors

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import at.htl.neudorfer.booksapp.data.Author
import at.htl.neudorfer.booksapp.model.AppModule
import at.htl.neudorfer.booksapp.model.AuthorsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorsViewModel @Inject constructor(
    private val authorsRepository: AuthorsRepository
): ViewModel() {
    val TAG = AuthorsViewModel::class.java.name;

    init {
        viewModelScope.launch {
            //addAuthor(Author("Hans", 0)) // Adding Test data
            val authors = getAuthors()
            Log.d(TAG, "Authors: $authors")
            authorsState.value = authors
        }
    }

    val authorsState: MutableState<List<Author>> = mutableStateOf((emptyList<Author>()))

    private suspend fun getAuthors():List<Author> {
        return authorsRepository.getBookAuthors();
    }


    fun addAuthor(author: Author) = viewModelScope.launch(Dispatchers.IO) {
        authorsRepository.insertAuthor(author)
    }

}