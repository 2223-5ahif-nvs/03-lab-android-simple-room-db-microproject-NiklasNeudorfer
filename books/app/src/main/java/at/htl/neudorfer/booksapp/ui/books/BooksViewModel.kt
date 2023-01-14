package at.htl.neudorfer.booksapp.ui.books

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import at.htl.neudorfer.booksapp.data.Book
import at.htl.neudorfer.booksapp.model.BooksRepository
import kotlinx.coroutines.launch

class BooksViewModel(
    private val booksRepository: BooksRepository = BooksRepository()
): ViewModel() {
    val TAG = BooksViewModel::class.java.name;

    init {
        viewModelScope.launch {
            val books = getBooks()
            Log.d(TAG, "Books: $books")
            booksState.value = books
        }
    }

    val booksState: MutableState<List<Book>> = mutableStateOf((emptyList<Book>()))

    suspend fun getBooks():List<Book> {
        return booksRepository.getBooks();
    }
}