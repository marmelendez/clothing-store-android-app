package mx.itesm.clothingstore.ui.Profile

import RecyclerAdapterPurchases
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mx.itesm.clothingstore.R
import mx.itesm.clothingstore.data.model.Product
import mx.itesm.clothingstore.data.model.Purchase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PurchaseFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PurchaseFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var recyclerList: RecyclerView
    private lateinit var purchaseList: MutableList<Purchase>

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
        val view = inflater.inflate(R.layout.fragment_purchase, container, false)

        purchaseList = mutableListOf()
        fillPurchaseList()
        recyclerList = view.findViewById(R.id.fragPurchaseRvRecycler)
        recyclerList.layoutManager = LinearLayoutManager(context)
        val favoritesAdapter = RecyclerAdapterPurchases(purchaseList)
        recyclerList.adapter = favoritesAdapter

        return view
    }

    private fun fillPurchaseList() {
        purchaseList.add(Purchase(1,812.12F, "Credit card", "Calle 7", "07/02/2021",listOf(Product("blusa", 123F))))
        purchaseList.add(Purchase(2,950.00F, "Debit card", "Calle 8", "08/03/2021",listOf(Product("blusa", 123F))))
        purchaseList.add(Purchase(3,500.00F, "Credit card", "Calle 9", "09/04/2021",listOf(Product("blusa", 123F))))
        purchaseList.add(Purchase(4,450.50F, "Debit card", "Calle 10", "10/05/2021",listOf(Product("blusa", 123F))))
        purchaseList.add(Purchase(5,800.00F, "Credit card", "Calle 11", "11/06/2021",listOf(Product("blusa", 123F))))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PurchaseFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PurchaseFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}