package com.example.shoplistryeah.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoplistryeah.R
import com.example.shoplistryeah.domain.ShopItem

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {
    var count = 0
    var shopList = listOf<ShopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    companion object {
        const val ENABLED = 1
        const val DISABLED = 0
        const val MAX_POOL_SIZE = 7
    }


    class ShopItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvCount = view.findViewById<TextView>(R.id.tv_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        Log.d("onCreateViewHolder", "count: ${++count}")
            val layout = when (viewType) {
                ENABLED -> R.layout.item_shop_enabled
                DISABLED -> R.layout.item_shop_disabled
                else -> throw RuntimeException("Unknown viewType: $viewType")
            }
            val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
            return ShopItemViewHolder(view)
        }


    override fun getItemViewType(position: Int): Int {
        return if (shopList[position].enabled) {
            ENABLED
        } else {
            DISABLED
        }
    }

    override fun getItemCount(): Int {
        return shopList.size
    }

    override fun onBindViewHolder(viewHolder: ShopItemViewHolder, position: Int) {
        val shopItem = shopList[position]
        viewHolder.tvName.text = shopItem.name
        viewHolder.tvCount.text = shopItem.count.toString()
        viewHolder.view.setOnLongClickListener {
            true
        }
    }
}
