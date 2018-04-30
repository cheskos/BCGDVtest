package com.chisko.bcgdvtest.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chisko.bcgdvtest.R
import com.chisko.bcgdvtest.model.RestaurantModel
import kotlinx.android.synthetic.main.item_restaurant_list.view.*

class RestaurantRecyclerAdapter(private val items: ArrayList<RestaurantModel>):
        RecyclerView.Adapter<RestaurantRecyclerAdapter.RestaurantViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_restaurant_list, parent, false)
        return RestaurantViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val model = items[position]
        holder.bind(model)
    }

    fun updateItems(newItems: List<RestaurantModel>) {
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class RestaurantViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name = itemView.item_name
        val schedule = itemView.item_hours

        fun bind(item: RestaurantModel) {
            name.text = item.name
            schedule.text = item.schedule
        }
    }
}