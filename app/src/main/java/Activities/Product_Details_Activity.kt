package Activities

import Models.Product
import Models.Review
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.chatwisetask.R
import com.example.chatwisetask.databinding.ActivityProductDetailsBinding

class Product_Details_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productList = intent.getSerializableExtra("PRODUCT_LIST") as? Product
        if (productList != null) {
            binding.productTitle.text = "Tittle: \n"+productList.title
            binding.productDescription.text = "Discription: \n"+productList.description
            binding.productDimensions.text = "Dimention: \n"+productList.dimensions.height +", "+ productList.dimensions.width + ", " + productList.dimensions.depth
            binding.productRating.text = "Ratings: \n"+productList.rating.toString()
            displayReviews(productList.reviews)
            binding.productPrice.text = "Product price: \n" + productList.price.toString()
            binding.productStock.text = "Stock: \n"+ productList.stock.toString()
            binding.productBrand.text = "Brand: \n"+ productList.brand.toString()
            binding.productReturnPolicy.text = "Return Policy: \n"+ productList.returnPolicy.toString()
            binding.productShippingInfo.text = "Shipping Info: \n" + productList.shippingInformation.toString()


        } else {
            Toast.makeText(this, "this is null", Toast.LENGTH_SHORT).show()
        }
    }

    private fun displayReviews(reviews: List<Review>) {
        if (reviews.isNotEmpty()) {
            val reviewText = StringBuilder()
            for (review in reviews) {
                reviewText.append("Reviewer: ${review.reviewerName}\n")
                reviewText.append("Email: ${review.reviewerEmail}\n")
                reviewText.append("Rating: ${review.rating}\n")
                reviewText.append("Comment: ${review.comment}\n")
                reviewText.append("Date: ${review.date}\n")
                reviewText.append("\n")
            }
            binding.productReviews.text = reviewText.toString()
        } else {
            binding.productReviews.text = "No reviews available."
        }
    }
}