package Repository

import Models.ItemData
import Retrofitpackage.ApiInterface
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Product_Repo (private val apiInterface : ApiInterface) {

    private val _allProducts = MutableLiveData<ItemData>()

    val allProducts: LiveData<ItemData>
        get() = _allProducts

     suspend fun getProduct() {
        apiInterface.getdata().enqueue(object : Callback<ItemData> {
            override fun onResponse(call: Call<ItemData>, response: Response<ItemData>) {
                if (response.isSuccessful) {
                    _allProducts.postValue(response.body())
                } else {
                    Log.d("the error", "Response not successful: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ItemData>, t: Throwable) {
                Log.d("the error", t.toString())
            }
        })
    }

}