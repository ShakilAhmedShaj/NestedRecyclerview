package com.decimalab.nestedrecyclerview.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.decimalab.nestedrecyclerview.R
import com.decimalab.nestedrecyclerview.databinding.MainFragmentBinding
import com.decimalab.nestedrecyclerview.model.Audio
import com.decimalab.nestedrecyclerview.model.Document
import com.decimalab.nestedrecyclerview.model.Item
import com.decimalab.nestedrecyclerview.model.Video
import com.decimalab.nestedrecyclerview.view.main.MainFragment

class MainFragment : Fragment(), CardClickListener {
    private var mViewModel: MainViewModel? = null
    private lateinit var binding: MainFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        mViewModel!!.listMutableLiveData.observe(viewLifecycleOwner, { items ->
            val itemsAdapter = MainItemsAdapter(items, this@MainFragment)
            binding!!.myAdapter = itemsAdapter
        })
    }

    override fun cardClicked(item: Item?) {
        when (item) {
            is Audio -> {
                Toast.makeText(context, "Audio : " + item.itemTitle, Toast.LENGTH_SHORT).show()
            }
            is Video -> {
                Toast.makeText(context, "Video : " + item.itemTitle, Toast.LENGTH_SHORT).show()
            }
            is Document -> {
                Toast.makeText(context, "Document : " + item.itemTitle, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}