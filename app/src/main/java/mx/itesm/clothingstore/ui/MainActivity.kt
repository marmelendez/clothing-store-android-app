package mx.itesm.clothingstore.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.itesm.clothingstore.databinding.ActivityMainBinding
import mx.itesm.clothingstore.ui.Profile.ProfileActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }
}