package com.decimalab.nestedrecyclerview.view.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.decimalab.nestedrecyclerview.BR
import com.decimalab.nestedrecyclerview.R
import com.decimalab.nestedrecyclerview.databinding.ParentItemRowBinding
import com.decimalab.nestedrecyclerview.model.*
import com.decimalab.nestedrecyclerview.view.main.MainItemsAdapter.MyViewHolder

class MainItemsAdapter(private val itemList: List<Item>, private val listener: CardClickListener) :
    RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: ParentItemRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.parent_item_row, parent, false
        )
        return MyViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemList[position]
        if (item is Audio) {
            item.imageResource = R.drawable.ic_audio
        } else if (item is Video) {
            item.imageResource = R.drawable.ic_video
        } else if (item is Document) {
            item.imageResource = R.drawable.ic_doc
        } else {
            val chapter = item as Chapter
            val childItemsAdapter = ChildItemsAdapter(chapter.chapterItem, listener)
            holder.itemRowBinding.childItemAdapter = childItemsAdapter
            item.imageResource = R.drawable.ic_doc
        }
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class MyViewHolder(var itemRowBinding: ParentItemRowBinding, listener: CardClickListener) :
        RecyclerView.ViewHolder(
            itemRowBinding.root
        ), CardClickListener {
        private val listener: CardClickListener
        fun bind(obj: Any?) {
            itemRowBinding.setVariable(BR.model, obj)
            itemRowBinding.executePendingBindings()
        }

        override fun cardClicked(item: Item?) {
            if (item is Chapter) {


                if (item.isExpanded) {
                    itemRowBinding.childRecyclerView.visibility = View.GONE
                    item.isExpanded = false
                    bind(item)
                } else {
                    itemRowBinding.childRecyclerView.visibility = View.VISIBLE
                    item.isExpanded = true
                    bind(item)
                }
            } else listener.cardClicked(item)
        }

        init {
            itemRowBinding.itemClickListener = this
            this.listener = listener
        }
    }
}