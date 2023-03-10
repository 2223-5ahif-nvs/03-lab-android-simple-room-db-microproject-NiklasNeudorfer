package at.htl.neudorfer.booksapp.ui.favouriteAuthors

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import at.htl.neudorfer.booksapp.data.Author
import at.htl.neudorfer.booksapp.model.AuthorsRepository
import at.htl.neudorfer.booksapp.ui.authors.AuthorsViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteAuthorsViewModel @Inject constructor(
    private val authorsRepository: AuthorsRepository
) : ViewModel() {
    var authors by mutableStateOf(emptyList<Author>())

    init {
        viewModelScope.launch {
            getAuthors()
        }
    }

    suspend fun getAuthors() {
        authorsRepository.getAllAuthorsFromDB().collect { r -> authors = r }
    }
}