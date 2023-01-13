package at.htl.neudorfer.booksapp.model.api

import at.htl.neudorfer.booksapp.data.Author
import at.htl.neudorfer.booksapp.data.Book
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ApiService {

    @GET("book/all")
    suspend fun getBooks(): List<Book>

    @GET("author/all")
    suspend fun getAuthors(): List<Author>

    companion object{
        private var apiService: ApiService? = null
        fun getInstance(): ApiService {
            if(apiService == null){
                apiService = Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}