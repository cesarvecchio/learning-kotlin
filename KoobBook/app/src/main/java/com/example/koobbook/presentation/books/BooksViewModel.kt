package com.example.koobbook.presentation.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koobbook.R
import com.example.koobbook.data.ApiService
import com.example.koobbook.data.model.Book
import com.example.koobbook.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()
    val viewFlipperLiveData: MutableLiveData<Pair<Int, Int?>> = MutableLiveData()

    fun getBooks() {
//        booksLiveData.value = createFakeBooks()
        ApiService.service.getBooks().enqueue(object: Callback<BookBodyResponse>{
            override fun onResponse(
                call: Call<BookBodyResponse>,
                response: Response<BookBodyResponse>
            ) {
                when {
                    response.isSuccessful -> {
                        val books: MutableList<Book> = mutableListOf()

                        response.body()?.let{ bookBodyResponse ->
                            for(result in bookBodyResponse.bookResults){
                                val book = result.bookDetailResponse[0].getBookModel()
                                books.add(book)
                            }
                        }
                        booksLiveData.value = books
                        viewFlipperLiveData.value = Pair(VIEW_FLIPPER_BOOKS, null)

                    }
                    response.code() == 401 -> {
                        viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.books_error_401)

                    }
                    else -> {
                        viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.books_error_400_generic)
                    }
                }
            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
                viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.books_error_500_generic)
            }

        })
    }

    companion object{
        private const val VIEW_FLIPPER_BOOKS = 1
        private const val VIEW_FLIPPER_ERROR = 2
    }

//    fun createFakeBooks(): List<Book>{
//        return listOf(
//            Book("Title 1", "Author 1"),
//            Book("Title 2", "Author 2"),
//            Book("Title 3", "Author 3")
//        )
//    }
}