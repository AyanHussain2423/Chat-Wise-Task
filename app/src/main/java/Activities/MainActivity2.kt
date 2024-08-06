package Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chatwisetask.R
import com.example.chatwisetask.databinding.ActivityMain2Binding

private lateinit var binding : ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
binding.button.setOnClickListener{
    val intent = Intent(this,MainActivity::class.java)
    startActivity(intent)
}
    }
}