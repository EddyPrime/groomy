package com.example.groomy.ui.pets

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.groomy.databinding.FragmentPetsBinding


class PetsFragment : Fragment() {

    private var _binding: FragmentPetsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val petsViewModel =
            ViewModelProvider(this).get(PetsViewModel::class.java)

        _binding = FragmentPetsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val addPetButton: Button = binding.buttonAddPet
        addPetButton.setOnClickListener { v ->
            Log.println(Log.DEBUG, "PET", "Add Pet Button Clicked")
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}