package mx.itesm.clothingstore.ui.Profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.PopupMenu
import mx.itesm.clothingstore.R
import mx.itesm.clothingstore.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.profileIbSettings.setOnClickListener {
            showConfigMenu(it)
        }
    }

    private fun showConfigMenu(view: View) {
        val popupMenu = PopupMenu(this, view)

        popupMenu.menuInflater.inflate(R.menu.configuration_menu, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_data -> {
                    /*val bundle = Bundle()
                    bundle.putString(USERNAME, username)

                    val intent = Intent(this, ConfigAccountDataActivity::class.java).apply {
                        putExtras(bundle)
                    }

                    startActivity(intent)*/
                }
                R.id.menu_address -> {

                }
                R.id.menu_payment -> {

                }
                R.id.menu_logout -> {

                }
            }
            true
        }
        popupMenu.show()
    }
}