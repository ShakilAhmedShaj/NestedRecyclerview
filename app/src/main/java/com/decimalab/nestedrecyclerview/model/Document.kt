package com.decimalab.nestedrecyclerview.model

class Document(itemTitle: String?, subTitle: String) : Item(itemTitle) {
    var subTitle: String

    init {
        super.itemSubTitle = subTitle
        this.subTitle = subTitle
    }
}