package at.htl.neudorfer.booksapp.ui.authors

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import at.htl.neudorfer.booksapp.data.Author
import at.htl.neudorfer.booksapp.model.AuthorsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorsViewModel @Inject constructor(
    private val authorsRepository: AuthorsRepository
) : ViewModel() {
    val TAG = AuthorsViewModel::class.java.name;

    init {
        viewModelScope.launch {
            val authors = getAuthors()
            //getAuthorsFromDB()

            Log.d(TAG, "Authors: $authors")

            authorsState.value = authors

            getAuthorsFromDB()
        }
    }

    val authorsState: MutableState<List<Author>> = mutableStateOf((emptyList<Author>()))
    val authorsStateDB: MutableState<List<Author>> = mutableStateOf((emptyList<Author>()))

    private suspend fun getAuthors(): List<Author> {
        try {
            return authorsRepository.getBookAuthors();
        } catch (e: Exception) {
            Log.e(TAG, "Error while getting authors", e)
            return emptyList()
        }
    }

    fun addAuthor(author: Author) = viewModelScope.launch(Dispatchers.IO) {
        authorsRepository.insertAuthor(author)
    }

    fun deleteAuthor(author: Author) = viewModelScope.launch(Dispatchers.IO) {
        authorsRepository.deleteAuthor(author)

    }

    private suspend fun getAuthorsFromDB() {
        return authorsRepository.getAllAuthorsFromDB().collect { r -> authorsStateDB.value = r }
    }
}