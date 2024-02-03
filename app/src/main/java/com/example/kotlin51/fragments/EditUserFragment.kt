package com.example.kotlin51.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kotlin51.databinding.FragmentEditUserBinding
import com.example.kotlin51.preference.PrefernceHelper

class EditUserFragment : Fragment() {
    private var _binding: FragmentEditUserBinding? = null
    private val binding: FragmentEditUserBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListenners()

    }

    private fun setupListenners() = with(binding) {
        val preference = PrefernceHelper(requireActivity())
        saveButton.setOnClickListener {
            preference.user_name = usernameEditText.text.toString().trim()
            preference.age = ageEditText.text.toString().trim()
            preference.email = emailEditText.text.toString().trim()
            preference.password = passwordEditText.text.toString().trim()
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}