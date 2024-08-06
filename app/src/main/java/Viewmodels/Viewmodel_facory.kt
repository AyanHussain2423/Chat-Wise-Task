package Viewmodels

import Repository.Product_Repo
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class Viewmodel_facory(private val productRepo: Product_Repo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return Product_Viewmodel(productRepo) as T
    }
}