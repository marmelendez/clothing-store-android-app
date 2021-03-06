package mx.itesm.clothingstore.ui.Profile

import RecyclerAdapterFavorites
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mx.itesm.clothingstore.R
import mx.itesm.clothingstore.data.model.Product

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FavoriteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoriteFragment() : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var recyclerList: RecyclerView
    private lateinit var favoritesList: MutableList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorite, container, false)

        favoritesList = mutableListOf()
        fillFavoritesList()
        recyclerList = view.findViewById(R.id.fragFavoritesRvRecycler)
        recyclerList.layoutManager = GridLayoutManager(context,2)
        val favoritesAdapter = RecyclerAdapterFavorites(favoritesList)
        recyclerList.adapter = favoritesAdapter

        return view
    }

    private fun fillFavoritesList() {
        favoritesList.add(Product("Blusa", 123.5F))
        favoritesList.add(Product("Pantalon", 150.0F))
        favoritesList.add(Product("Chamarra", 200.3F))
        favoritesList.add(Product("Tenis", 500.0F))
        favoritesList.add(Product("Vestido", 856.0F))
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FavoriteFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FavoriteFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}