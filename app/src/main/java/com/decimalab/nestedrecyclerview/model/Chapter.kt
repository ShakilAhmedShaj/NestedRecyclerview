package com.decimalab.nestedrecyclerview.model

import java.util.*

class Chapter(itemTitle: String?) : Item(itemTitle) {
    var chapterItem = ArrayList<Item>()
    var isExpanded = false
}