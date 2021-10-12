package mx.itesm.clothingstore.ui.Profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

        val extras = intent.extras
        var type = ""
        if (extras != null) {
            type = extras.getString("type").toString()
            when (type) {
                "address" -> {replaceAddressFragment()}
                "payment" -> {replacePaymentFragment()}
                else -> {replaceDataFragment()}
            }
        } else {
            Toast.makeText(this, "No se pudo obtener la información", Toast.LENGTH_SHORT).show()
        }
    }



    private fun replaceDataFragment() {
        val fragment = ConfigDataFragment()
        val transact = supportFragmentManager.beginTransaction()
        transact.add(R.id.configFcContainer, fragment, TAG_FRAGMENT)
        transact.commit()
    }

    private fun replaceAddressFragment() {
        val fragment = ConfigAddressFragment()
        val transact = supportFragmentManager.beginTransaction()
        transact.add(R.id.configFcContainer, fragment, TAG_FRAGMENT)
        transact.commit()
    }

    private fun replacePaymentFragment() {
        val fragment = ConfigPaymentFragment()
        val transact = supportFragmentManager.beginTransaction()
        transact.add(R.id.configFcContainer, fragment, TAG_FRAGMENT)
        transact.commit()
    }

    companion object{
        private const val TAG_FRAGMENT= "config_fragment"
    }
}