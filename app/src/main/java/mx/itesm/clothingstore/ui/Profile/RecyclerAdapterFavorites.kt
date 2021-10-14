import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.itesm.clothingstore.R
import mx.itesm.clothingstore.data.model.Product
import mx.itesm.clothingstore.ui.Profile.ConfigurationActivity

class RecyclerAdapterFavorites(
    private val products: List<Product>) : RecyclerView.Adapter<RecyclerAdapterFavorites.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.product_favorite_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val productName = view.findViewById(R.id.productTvName) as TextView
        val price = view.findViewById(R.id.productTvPrice) as TextView
        //val image = view.findViewById(R.id.imgProduct) as ImageView

        fun bind(product: Product){
            productName.text = product.name
            price.text = product.price.toString()
            //image.setImageResource(product.image)

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