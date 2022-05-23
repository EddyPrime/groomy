package com.example.groomy.ui.addPet

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.groomy.R
import com.example.groomy.databinding.FragmentAddPetBinding
import com.example.groomy.databinding.FragmentBookBinding
import com.example.groomy.ui.book.BookViewModel
import com.example.groomy.ui.pets.Pet
import com.example.groomy.ui.pets.Pets
import com.example.groomy.ui.pets.PetsFragment

class AddPetFragment : Fragment() {

    private var _binding: FragmentAddPetBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val addPetViewModel =
            ViewModelProvider(this).get(AddPetViewModel::class.java)

        _binding = FragmentAddPetBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textPetName: EditText = binding.editTextAddPetName
        val textPetRace: EditText = binding.editTextAddPetRace
        val textPetAge: EditText = binding.editTextAddPetAge
        val textPetSize: EditText = binding.editTextAddPetSize
        val textPetHair: EditText = binding.editTextAddPetHair
        val textPetWeight: EditText = binding.editTextAddPetWeight

        val confirmAddPetButton: Button = binding.buttonAddPetConfirm
        confirmAddPetButton.setOnClickListener {
            Log.println(Log.DEBUG, "PET", "Confirm Add Pet Button Clicked")
            val petName: String = textPetName.text.toString()
            val petRace: String = textPetRace.text.toString()
            val petAge: Int = textPetAge.text.toString().toInt()
            val petSize: String = textPetSize.text.toString()
            val petHair: String = textPetHair.text.toString()
            val petWeight: Float = textPetWeight.text.toString().toFloat()

            Pets.addPet(petName,petRace,petAge,petSize,petHair,petWeight)
            Log.println(Log.DEBUG, "ADD PET", Pets.toString())

            requireActivity().supportFragmentManager.beginTransaction().
            replace(R.id.container, PetsFragment()).addToBackStack(null).commit()
        }

        val cancelAddPetButton: Button = binding.buttonAddPetCancel
        cancelAddPetButton.setOnClickListener {
            Log.println(Log.DEBUG, "PET", "Cancel Add Pet Button Clicked")

            requireActivity().supportFragmentManager.beginTransaction().
            replace(R.id.container, PetsFragment()).addToBackStack(null).commit()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}