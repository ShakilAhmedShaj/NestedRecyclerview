package com.decimalab.nestedrecyclerview.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter

open class Item(var itemTitle: String?) {
    var itemSubTitle: String? = null
    var imageResource = 0

}

@BindingAdapter("android:src")
fun setImageViewResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}