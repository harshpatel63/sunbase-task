package com.example.sunbase_task.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.sunbase_task.databinding.FragmentHomeBinding
import com.example.sunbase_task.network.properties.ImageObjectResponse
import dagger.hilt.android.AndroidEntryPoint
import android.net.ConnectivityManager
import androidx.fragment.app.viewModels
import com.example.sunbase_task.db.Image


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val gridView = binding.homeGridView
        val networkData = ImageObjectResponse()
        val localData = ArrayList<Image>()
        val networkAdapter = context?.let { HomeNetworkAdapter(it, networkData) }
        val localAdapter = context?.let { HomeLocalAdapter(it, localData) }

        val cm = activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.getNetworkCapabilities(cm.activeNetwork)

        if(networkInfo != null) {
            gridView.adapter = networkAdapter
            homeViewModel.getImagesFromNetwork()
        } else {
            gridView.adapter = localAdapter
            homeViewModel.getCachedImagesFromDatabase()
        }


        homeViewModel.data.observe(viewLifecycleOwner, Observer {
            it.data?.let {
                networkAdapter?.updateArray(it)
            }
        })

        homeViewModel.cachedImages.observe(viewLifecycleOwner, Observer {
            it?.let {
                localAdapter?.updateArray(it)
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}