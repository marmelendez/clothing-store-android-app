package mx.itesm.clothingstore.data.model

data class Purchase (
    val id: Int,
    val total: Float,
    val payment: String,
    val address: String,
    val date: String,
    val listProducts: List<Product>
) {
}