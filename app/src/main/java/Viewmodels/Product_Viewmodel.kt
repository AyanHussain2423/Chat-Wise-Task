package Viewmodels

import Models.ItemData
import Repository.Product_Repo
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Product_Viewmodel(private val productRepo: Product_Repo): ViewModel(){
    init {
        viewModelScope.launch (Dispatchers.IO){
            productRepo.getProduct()
        }
    }

    val Product : LiveData<ItemData>
        get() = productRepo.allProducts

}