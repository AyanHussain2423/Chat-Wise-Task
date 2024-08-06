package Activities
import Adapters.ProductListAdapter
import Models.Product
import Retrofitpackage.ApiInterface
import Repository.Product_Repo
import Viewmodels.Product_Viewmodel
import Retrofitpackage.ApiUtility
import Viewmodels.Viewmodel_facory
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatwisetask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapters: ProductListAdapter
    private lateinit var mlist: MutableList<Product>
    private lateinit var viewmodel: Product_Viewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mlist = mutableListOf()
        adapters = ProductListAdapter(mutableListOf(),{ product->
            senddata(product)
        })

        binding.ProductRc.setHasFixedSize(false)
        binding.ProductRc.adapter = adapters
        binding.ProductRc.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL ,false)

        val apiInterface = ApiUtility.getinstance().create(ApiInterface::class.java)
        val productRepository = Product_Repo(apiInterface)
        viewmodel = ViewModelProvider(this, Viewmodel_facory(productRepository))
            .get(Product_Viewmodel::class.java)

        viewmodel.Product.observe(this, Observer{
            adapters.Setdata(it.products)

        })
    }

    private fun senddata(product: Product) {
        val intent = Intent(this,Product_Details_Activity::class.java).apply {
            putExtra("PRODUCT_LIST", product)
        }
        startActivity(intent)
    }

}