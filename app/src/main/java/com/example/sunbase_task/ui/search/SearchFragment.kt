package com.example.sunbase_task.ui.search

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.sunbase_task.R
import com.example.sunbase_task.databinding.FragmentSearchBinding
import com.example.sunbase_task.network.properties.Result
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
        val textView = binding.text
        val gridView = binding.searchGridView
        val adapter = context?.let { SearchAdapter(it, data) }
        gridView.adapter = adapter

        val cm = activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.getNetworkCapabilities(cm.activeNetwork)

        if(networkInfo == null) {
            searchView.visibility = View.GONE
            textView.visibility = View.VISIBLE
            textView.text = context?.getText(R.string.you_do_not_have_an_active_internet_connection)
        } else
            searchView.visibility = View.VISIBLE


        searchViewModel.data.observe(viewLifecycleOwner, Observer {
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