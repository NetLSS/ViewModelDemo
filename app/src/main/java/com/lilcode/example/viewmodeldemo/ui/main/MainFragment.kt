package com.lilcode.example.viewmodeldemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lilcode.example.viewmodeldemo.R
import com.lilcode.example.viewmodeldemo.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = requireNotNull(_binding)

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.resultText.text = viewModel.getResult().toString()

        binding.convertButton.setOnClickListener {
            if (binding.dollarText.text.isNotEmpty()) {
                viewModel.setAmount(binding.dollarText.text.toString())
                binding.resultText.text = viewModel.getResult().toString()
            } else {
                binding.resultText.text = getString(R.string.no_value)
            }
        }
    }

}