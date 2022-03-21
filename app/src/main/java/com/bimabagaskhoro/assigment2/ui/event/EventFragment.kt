package com.bimabagaskhoro.assigment2.ui.event

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bimabagaskhoro.assigment2.R
import com.bimabagaskhoro.assigment2.databinding.FragmentEventBinding
import com.bimabagaskhoro.assigment2.ui.adapter.EventAdapter
import com.bimabagaskhoro.assigment2.ui.choose.ChooseFragment

class EventFragment : Fragment() {
    private var _binding: FragmentEventBinding? = null
    private val binding get() = _binding!!
    private lateinit var eventAdapter: EventAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEventBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(this,
                ViewModelProvider.NewInstanceFactory())[EventViewModel::class.java]
            val movie = viewModel.getMovie()
            eventAdapter = EventAdapter()
            eventAdapter.setData(movie)
            eventAdapter.onItemClick = {
                val bundle = Bundle().apply { putParcelable(ChooseFragment.EXTRA_DATA_EVENT, it) }
                findNavController().navigate(R.id.action_eventFragment_to_chooseFragment, bundle)
            }
            binding.apply {
                rvEvent.layoutManager = LinearLayoutManager(context)
                rvEvent.setHasFixedSize(true)
                rvEvent.adapter = eventAdapter
                imgBack.setOnClickListener {
                    findNavController().navigate(R.id.action_eventFragment_to_chooseFragment)
                }
                imgMaps.setOnClickListener {
                    findNavController().navigate(R.id.action_eventFragment_to_mapsActivity)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}