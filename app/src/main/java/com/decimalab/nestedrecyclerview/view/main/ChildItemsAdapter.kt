package com.decimalab.nestedrecyclerview.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.decimalab.nestedrecyclerview.BR
import com.decimalab.nestedrecyclerview.R
import com.decimalab.nestedrecyclerview.databinding.ParentItemRowBinding
import com.decimalab.nestedrecyclerview.model.Audio
import com.decimalab.nestedrecyclerview.model.Document
import com.decimalab.nestedrecyclerview.model.Item
import com.decimalab.nestedrecyclerview.model.Video
import com.decimalab.nestedrecyclerview.view.main.ChildItemsAdapter.MyChildViewHolder

class ChildItemsAdapter(private val itemList: List<Item>, private val listener: CardClickListener) :
    RecyclerView.Adapter<MyChildViewHolder>(), CardClickListener {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyChildViewHolder {
        val binding: ParentItemRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.parent_item_row, parent, false
        )
        return MyChildViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyChildViewHolder, position: Int) {
        val item = itemList[position]
        when (item) {
            is Audio -> {
                item.imageResource = R.drawable.ic_audio
            }
            is Video -> {
                item.imageResource = R.drawable.ic_video
            }
            is Document -> {
                item.imageResource = R.drawable.ic_doc
            }
            else -> {
                item.imageResource = R.drawable.ic_doc
            }
        }
        holder.bind(item)
        holder.itemRowBinding.itemClickListener = this
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun cardClicked(item: Item?) {
        listener.cardClicked(item)
    }

    class MyChildViewHolder(var itemRowBinding: ParentItemRowBinding) : RecyclerView.ViewHolder(
        itemRowBinding.root
    ) {
        fun bind(obj: Any?) {
            itemRowBinding.setVariable(BR.model, obj)
            itemRowBinding.executePendingBindings()
        }
    }
}