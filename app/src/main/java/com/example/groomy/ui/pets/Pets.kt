package com.example.groomy.ui.pets

class Pet(
    private val name: String,
    private val race: String,
    private val age: Int,
    private val size: String,
    private val hair: String,
    private val weight: Float
    )

object Pets {

    private val pets: MutableList<Pet> = mutableListOf()

    fun addPet(pet: Pet) {
        pets.add(pet)
    }

    fun removePet(name: String) {

    }
}