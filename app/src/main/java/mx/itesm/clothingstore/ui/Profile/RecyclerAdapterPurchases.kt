import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.itesm.clothingstore.R
import mx.itesm.clothingstore.data.model.Product
import mx.itesm.clothingstore.data.model.Purchase
import mx.itesm.clothingstore.ui.Profile.ConfigurationActivity

class RecyclerAdapterPurchases(
    private val purchases: List<Purchase>) : RecyclerView.Adapter<RecyclerAdapterPurchases.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.purchase_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val purchases = purchases[position]
        holder.bind(purchases)
    }

    override fun getItemCount(): Int {
        return purchases.size
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val id = view.findViewById(R.id.purchaseTvIDvalue) as TextView
        val total = view.findViewById(R.id.purchaseTvTotalValue) as TextView
        val payment = view.findViewById(R.id.purchaseTvPaymentValue) as TextView
        val address = view.findViewById(R.id.purchaseTvAddressValue) as TextView
        val date = view.findViewById(R.id.productTvDateValue) as TextView

        fun bind(purchase: Purchase){
            id.text = purchase.id.toString()
            total.text = purchase.total.toString()
            payment.text = purchase.payment
            address.text = purchase.address
            date.text = purchase.date

            itemView.setOnClickListener { v ->
                /*val bundle = Bundle()
                bundle.putInt(PRODUCTID, product.idProduct)
                bundle.putString(USERNAME, username)*/

                val intent = Intent(v.context, ConfigurationActivity::class.java)
                v.context.startActivity(intent)
            }
        }
    }
}