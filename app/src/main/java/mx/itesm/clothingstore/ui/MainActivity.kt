package mx.itesm.clothingstore.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.itesm.clothingstore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}