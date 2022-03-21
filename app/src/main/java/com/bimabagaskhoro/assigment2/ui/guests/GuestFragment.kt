package com.bimabagaskhoro.assigment2.ui.guests

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bimabagaskhoro.assigment2.R
import com.bimabagaskhoro.assigment2.data.Resource
import com.bimabagaskhoro.assigment2.databinding.FragmentGuestBinding
import com.bimabagaskhoro.assigment2.ui.adapter.GuestAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GuestFragment : Fragment() {

    private val viewModel: GuestViewModel by viewModels()

    private var _binding: FragmentGuestBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGuestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val guestAdapter = GuestAdapter()
            guestAdapter.onItemClick = {
                findNavController().navigate(R.id.action_guestFragment_to_chooseFragment)
            }
            viewModel.guest.observe(viewLifecycleOwner, { tourism ->
                if (tourism != null) {
                    when (tourism) {
                        is Resource.Loading -> binding.progressbar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressbar.visibility = View.GONE
                            guestAdapter.setData(tourism.data)
                        }
                        is Resource.Error -> {
                            binding.progressbar.visibility = View.VISIBLE
                        }
                    }
                }
            })

            binding.apply {
                rvGuest.layoutManager =  GridLayoutManager(context, 2)
                rvGuest.setHasFixedSize(true)
                rvGuest.adapter = guestAdapter
                imgBack.setOnClickListener {
                    it.findNavController().navigate(R.id.action_guestFragment_to_chooseFragment)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}