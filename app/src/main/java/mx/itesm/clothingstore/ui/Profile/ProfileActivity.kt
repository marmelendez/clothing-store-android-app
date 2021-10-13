package mx.itesm.clothingstore.ui.Profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
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

        binding.profileTvFavorites.setOnClickListener {
            displayFragment(
                binding.profileTvFavorites,
                binding.profileTvPurchase,
                FavoriteFragment()
            )

        }

        binding.profileTvPurchase.setOnClickListener {
            displayFragment(
                binding.profileTvPurchase,
                binding.profileTvFavorites,
                null,
                PurchaseFragment()
            )

        }
    }

    fun displayFragment(active: TextView, inactive: TextView, favoriteFrag: FavoriteFragment? = null, purchaseFrag: PurchaseFragment? = null) {
        active.setTextColor(resources.getColor(R.color.primary_blue))
        inactive.setTextColor(resources.getColor(R.color.primary_black))
        val currentFragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT)
        val transaction = supportFragmentManager.beginTransaction()
        if(currentFragment != null) {
            transaction.remove(currentFragment)
        }
        if (favoriteFrag != null) {
            transaction.add(R.id.profileFcContainer, favoriteFrag, TAG_FRAGMENT)
            transaction.commit()
        } else if (purchaseFrag != null) {
            transaction.add(R.id.profileFcContainer, purchaseFrag, TAG_FRAGMENT)
            transaction.commit()
        }
    }

    companion object{
        private const val TAG_FRAGMENT= "fragment"
    }

    private fun showConfigMenu(view: View) {
        val popupMenu = PopupMenu(this, view)

        popupMenu.menuInflater.inflate(R.menu.configuration_menu, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_data -> {
                    val intent = Intent(applicationContext, ConfigurationActivity::class.java)
                    intent.putExtra("type", "data")
                    startActivity(intent)
                }
                R.id.menu_address -> {
                    val intent = Intent(applicationContext, ConfigurationActivity::class.java)
                    intent.putExtra("type", "address")
                    startActivity(intent)

                }
                R.id.menu_payment -> {
                    val intent = Intent(applicationContext, ConfigurationActivity::class.java)
                    intent.putExtra("type", "payment")
                    startActivity(intent)
                }
                R.id.menu_logout -> {

                }
            }
            true
        }
        popupMenu.show()
    }
}