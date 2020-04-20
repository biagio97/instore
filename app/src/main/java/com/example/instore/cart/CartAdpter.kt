package com.example.instore.cart

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instore.R
import kotlinx.android.synthetic.main.riga_cart.view.*
import models.OneProduct
import kotlin.text.Typography.euro

class CartAdpter(val cartList: MutableList<OneProduct>, val context: Context, val cartFragment: CartFragment) : RecyclerView.Adapter<ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.riga_cart, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun getItemCount(): Int {
        return cartList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val prodottoCart = cartList[position]

        Glide.with(context).load(prodottoCart.imgUrl).into(holder.tvImage)
        holder.tvNome.text = prodottoCart.nome
        holder.tvColore.text = "Colore: " + prodottoCart.prezzo.toString() + " " + euro
        holder.tvTaglia.text = "Taglia: " + prodottoCart.taglia
        holder.tvQuantita.text = "Quantità: " + prodottoCart.quantita_selz.toString()
        holder.tvCodice.text = "Cod. " + prodottoCart.cod

        holder.itemView.buttonDelete.setOnClickListener {

            cartList.removeAt(position)
            this.notifyDataSetChanged()
            this.notifyItemRemoved(position)
            cartFragment.aggiornaLayout()

        }

    }
}


class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    var tvImage = itemView.findViewById<ImageView>(R.id.imageCart)
    var tvNome = itemView.findViewById<TextView>(R.id.textNomeCart)
    var tvColore = itemView.findViewById<TextView>(R.id.textColoreCart)
    var tvTaglia = itemView.findViewById<TextView>(R.id.textTaglia)
    var tvQuantita = itemView.findViewById<TextView>(R.id.textQuantita)
    var tvCodice = itemView.findViewById<TextView>(R.id.textCodiceCart)

}
