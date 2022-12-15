package at.htl.neudorfer

import at.htl.neudorfer.books.data.Book
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ApiService {

    @GET("all")
    suspend fun getBooks(): List<Book>

    companion object{
        private var apiService: ApiService? = null
        fun getInstance(): ApiService{
            if(apiService == null){
                apiService = Retrofit.Builder()
                    .baseUrl("http://localhost:8080/book/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}