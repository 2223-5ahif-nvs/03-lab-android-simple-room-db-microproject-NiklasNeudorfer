package at.htl.neudorfer.books.rest

import at.htl.neudorfer.books.data.models.Author
import at.htl.neudorfer.books.data.models.Book
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "localhost:8080/"

interface APIService {
    @GET("author/all")
    suspend fun getAuthors(): List<Author>

    @GET("book/all")
    suspend fun getBooks(): List<Book>

    companion object {
        var apiService: APIService? = null
        fun getInstance(): APIService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(APIService::class.java)
            }
            return apiService!!
        }
    }
}