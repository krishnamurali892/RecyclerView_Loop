package com.example.networklist.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.networklist.adapter.UserAdapter
import com.example.networklist.databinding.NetworkListBinding
import com.example.networklist.utils.LoopingLayoutManager
import com.example.networklist.viewmodel.UserListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NetworkListFragment : Fragment(){

    lateinit var binding: NetworkListBinding
    private val userListViewModel: UserListViewModel by viewModels()
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //recyclerview

        val binding = NetworkListBinding.inflate(layoutInflater)

        viewManager = LoopingLayoutManager(
            requireContext(),                           // Pass the context.
            LoopingLayoutManager.HORIZONTAL,  // Pass the orientation. Vertical by default.
            false                           // Pass whether the views are laid out in reverse.
            // False by default.
        )
        userListViewModel.userResponse.observe(viewLifecycleOwner, Observer {
            Log.d("asd", "----------- :: "+it.userlist!!.get(0).firstName)
            CoroutineScope(Dispatchers.Main).launch {
                val adapter = UserAdapter(it.userlist!!)

                binding.networkList.layoutManager = viewManager
                binding.networkList.adapter = adapter
            }
        })


        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

}