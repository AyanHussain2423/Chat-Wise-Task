package Adapters

import Models.Product
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatwisetask.databinding.ProductitemsViewBinding

class ProductListAdapter(private var mlist: MutableList<Product>,
                         private val onItemClicked: (Product) -> Unit):
    RecyclerView.Adapter<ProductListAdapter.ProductItemView>() {

    companion object {
        private const val tittle = 0
        private const val product = 1
    }
    inner class ProductItemView(val binding: ProductitemsViewBinding  ): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemView {

        val binding = ProductitemsViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductItemView(binding)
    }
    override fun onBindViewHolder(holder: ProductItemView, position: Int) {
        with(holder) {
            with(mlist[position]) {
                binding.ItemTittle.text = this.title
                binding.ItemDiscription.text = this.description
                holder.itemView.setOnClickListener {
                    onItemClicked(this)
                }
            }
        }
    }
    override fun getItemCount(): Int {
        return mlist.size
    }
    fun Setdata(products: List<Product>){
        this.mlist = products.toMutableList()
        notifyDataSetChanged()
    }
}