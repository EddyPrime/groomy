package com.example.groomy.ui.pets

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.groomy.R
import com.example.groomy.databinding.FragmentAddPetBinding
import com.example.groomy.databinding.FragmentPetsBinding
import com.example.groomy.ui.addPet.AddPetFragment


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
        addPetButton.setOnClickListener {
            Log.println(Log.DEBUG, "PET", "Add Pet Button Clicked")

            /*
            val newFragmentAddPet = AddPetFragment()
            val fragmentTransaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.replace((requireView().parent as ViewGroup).id,newFragmentAddPet)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
            */

            requireActivity().supportFragmentManager.beginTransaction().
            replace(R.id.container, AddPetFragment()).addToBackStack(null).commit()

            /*
            findNavController().navigate(R.id.action_navigation_pets_to_navigation_add_pet)
            */

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}