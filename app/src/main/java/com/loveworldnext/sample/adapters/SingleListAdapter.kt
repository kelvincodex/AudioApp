package com.loveworldnext.sample.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.loveworldnext.sample.R
import com.loveworldnext.sample.model.Item

class SingleListAdapter(var context: Context, var itemList:ArrayList<Item>, var Click:(Item) -> Unit):
  RecyclerView.Adapter<SingleListAdapter.SingleItemViewHolder>(){



    class SingleItemViewHolder(var view:View):RecyclerView.ViewHolder(view){
        val itemName:MaterialTextView = view.findViewById(R.id.itemname)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleItemViewHolder {

        val layoutInflater = LayoutInflater.from(context).inflate(R.layout.itemview_list_item, parent, false)
        return SingleItemViewHolder(layoutInflater)

    }

    override fun onBindViewHolder(holder: SingleItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemName.text = item.itemTitle

        holder.itemView.setOnClickListener {
            Click.invoke(item)
        }


    }



    override fun getItemCount(): Int {
        return itemList.size
    }




}