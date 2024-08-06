package Retrofitpackage

import Models.ItemData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("products")
    fun getdata(): Call<ItemData>
}