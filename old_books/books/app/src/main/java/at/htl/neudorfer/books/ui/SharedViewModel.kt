package at.htl.neudorfer.books.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import at.htl.neudorfer.books.data.models.Author
import at.htl.neudorfer.books.data.models.Book
import at.htl.neudorfer.books.data.repositories.AuthorRepository
import at.htl.neudorfer.books.data.repositories.BookRepository
import at.htl.neudorfer.books.rest.APIService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@HiltViewModel
class SharedViewModel @Inject constructor (
    //private val authorRepository: AuthorRepository,
    //private val bookRepository: BookRepository
): ViewModel() {

    private val _allBooks = MutableStateFlow<List<Book>>(emptyList())
    val allBooks: StateFlow<List<Book>> = _allBooks

    private val _allAuthors = MutableStateFlow<List<Author>>(emptyList())
    val allAuthors: StateFlow<List<Author>> = _allAuthors

    fun getAllBooks(){
        viewModelScope.launch {
            var errorMessage: String by mutableStateOf("")
            val apiService = APIService.getInstance();

            try {
                _allAuthors.value = apiService.getAuthors()
                _allBooks.value = apiService.getBooks()

            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }



//            bookRepository.getAllBooks.collect {
//                _allBooks.value = it
//            }
//
//            authorRepository.getAllAuthors.collect {
//                _allAuthors.value = it
//            }
        }
    }


}