package at.htl.neudorfer.booksapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import at.htl.neudorfer.booksapp.model.api.ApiService
import at.htl.neudorfer.booksapp.data.Book
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    var bookListResponse:List<Book> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getBookList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val bookList = apiService.getBooks()
                System.out.println("DATA:")
                System.out.println(bookList)
                bookListResponse = bookList
            }
            catch (e: Exception) {
                System.out.println("ERROR:")
                System.out.println(e.message.toString())
                errorMessage = e.message.toString()
            }
        }
    }
}