package com.example.kotlin51.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kotlin51.R
import com.example.kotlin51.databinding.FragmentRegistrationBinding
import com.example.kotlin51.preference.PrefernceHelper

class RegistrationFragment : Fragment() {
    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListenners()
    }

    private fun setupListenners() = with(binding) {
        val preference = PrefernceHelper(requireActivity())
        registerButton.setOnClickListener {
            preference.user_name = userNameEditText.text.toString().trim()
            preference.age = userAgeEditText.text.toString().trim()
            preference.email = emailEditText.text.toString().trim()
            preference.password = passwordEditText.text.toString().trim()
            preference.isShowRegister = true
           findNavController().navigate(R.id.action_registrationFragment_to_infoUserFragment)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}