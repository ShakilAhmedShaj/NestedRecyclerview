package com.decimalab.nestedrecyclerview.repository

import androidx.lifecycle.MutableLiveData
import com.decimalab.nestedrecyclerview.model.*
import java.util.*

class Repository {

    val listMutableLiveData = MutableLiveData<ArrayList<Item>>()

    fun loadData() {
        val chapter1 = Chapter("Chapter 1")
        val video1 = Video("Video 1_1")
        val video2 = Video("Video 1_2")
        val document1 = Document("Document 1_1", "Shaj")
        val chapter1Item = ArrayList<Item>()
        chapter1Item.add(video1)
        chapter1Item.add(document1)
        chapter1Item.add(video2)
        chapter1.chapterItem = chapter1Item

        val chapter2 = Chapter("Chapter 2")
        val video3 = Video("Video 2_1")
        val video4 = Video("Video 2_2")
        val document3 = Document("Document 2_1", "Shakil")
        val audio1 = Audio("Audio 2_1")
        val chapter2Item = ArrayList<Item>()
        chapter2Item.add(document3)
        chapter2Item.add(video3)
        chapter2Item.add(video4)
        chapter2Item.add(audio1)
        chapter2.chapterItem = chapter2Item
        val video5 = Video("Video 3_1")
        val document4 = Document("Document 4_1", "Shaj")
        val itemList: MutableList<Item> = ArrayList()
        itemList.add(chapter1)
        itemList.add(chapter2)
        itemList.add(video5)
        itemList.add(document4)

        listMutableLiveData.value = itemList as ArrayList<Item>
    }
}