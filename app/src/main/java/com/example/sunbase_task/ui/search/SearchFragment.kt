package com.example.sunbase_task.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sunbase_task.databinding.FragmentSearchBinding
import com.example.sunbase_task.network.properties.ImageObjectResponse
import com.example.sunbase_task.network.properties.Result
import com.example.sunbase_task.network.properties.SearchObjectResponse
import com.example.sunbase_task.ui.home.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private val searchViewModel: SearchViewModel by viewModels()
    private var _binding: FragmentSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val data = ArrayList<Result>()

        val searchView = binding.searchView
        val gridView = binding.searchGridView
        val adapter = context?.let { SearchAdapter(it, data) }
        gridView.adapter = adapter


        searchViewModel.text.observe(viewLifecycleOwner, Observer {
            it.data?.let {
                adapter?.updateArray(it.results)
            }
        })

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(newText!=null)
                    searchViewModel.searchKeyword(newText)
                return false
            }

        })


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}