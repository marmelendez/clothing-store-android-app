package mx.itesm.clothingstore.ui.Profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import mx.itesm.clothingstore.R
import mx.itesm.clothingstore.databinding.ActivityConfigurationBinding
import mx.itesm.clothingstore.databinding.ActivityProfileBinding

class ConfigurationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfigurationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfigurationBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}