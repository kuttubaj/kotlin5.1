package com.example.kotlin51.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.kotlin51.R
import com.example.kotlin51.databinding.FragmentInfoUserBinding
import com.example.kotlin51.model.UserInfoViewModel
import com.example.kotlin51.model.UserModel
import com.example.kotlin51.preference.PrefernceHelper


class InfoUserFragment : Fragment() {

        private var _binding: FragmentInfoUserBinding? = null
        private val binding: FragmentInfoUserBinding get() = _binding!!
        private val secondViewModel: UserInfoViewModel by viewModels()

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            _binding = FragmentInfoUserBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            initialize()
            setupObserver()
        }

        private fun initialize() {
            val preferenceHelper = PrefernceHelper(requireActivity())
            secondViewModel.updateUserModel(
                UserModel(
                    preferenceHelper.user_name!!,
                    preferenceHelper.age!!,
                    preferenceHelper.email!!,
                    preferenceHelper.password!!
                )
            )
        }

        private fun setupObserver() = with(binding) {
            secondViewModel.userData.observe(viewLifecycleOwner) { userData ->
                userNameTextView.text = userData.user_name
                ageTextView.text = userData.age
                emailTextView.text = userData.email
                passwordTextView.text = userData.password
            }
            editButton.setOnClickListener {
                findNavController().navigate(R.id.action_infoUserFragment_to_editUserFragment22)
            }
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }