package at.htl.neudorfer.books

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import at.htl.neudorfer.ApiService
import at.htl.neudorfer.books.data.Book
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private var bookListResponse:List<Book> by mutableStateOf(listOf())
    private var errorMessage: String by mutableStateOf("")

    fun getBookList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val bookList = apiService.getBooks()
                bookListResponse = bookList
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}