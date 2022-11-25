package at.htl.neudorfer.books.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import at.htl.neudorfer.books.data.models.Author
import at.htl.neudorfer.books.data.models.Book
import at.htl.neudorfer.books.data.repositories.AuthorRepository
import at.htl.neudorfer.books.data.repositories.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SharedViewModel @Inject constructor (
    private val authorRepository: AuthorRepository,
    private val bookRepository: BookRepository
): ViewModel() {

    private val _allBooks = MutableStateFlow<List<Book>>(emptyList())
    val allBooks: StateFlow<List<Book>> = _allBooks

    private val _allAuthors = MutableStateFlow<List<Author>>(emptyList())
    val allAuthors: StateFlow<List<Author>> = _allAuthors


    fun getAllBooks(){
        viewModelScope.launch {
            bookRepository.getAllBooks.collect {
                _allBooks.value = it
            }

            authorRepository.getAllAuthors.collect {
                _allAuthors.value = it
            }
        }
    }


}