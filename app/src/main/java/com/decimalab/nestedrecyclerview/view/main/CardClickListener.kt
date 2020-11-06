package com.decimalab.nestedrecyclerview.view.main

import com.decimalab.nestedrecyclerview.model.Item

interface CardClickListener {
    fun cardClicked(item: Item?)
}