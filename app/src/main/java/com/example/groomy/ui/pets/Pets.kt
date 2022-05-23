package com.example.groomy.ui.pets

class Pet(
    private val name: String,
    private val race: String,
    private val age: Int,
    private val size: String,
    private val hair: String,
    private val weight: Float
    ) {

    override fun toString(): String {
        var buf: String = this.name + " "
        buf += this.race + " "
        buf += this.age.toString() + " "
        buf += this.size + " "
        buf += this.hair + " "
        buf += this.weight
        return buf
    }
}

object Pets {

    val pets: MutableList<Pet> = mutableListOf()

    fun addPet(name: String, race: String, age: Int, size: String, hair: String, weight: Float) {
        pets.add(Pet(name,race, age, size, hair, weight))
    }

    fun removePet(name: String) {}

    override fun toString(): String {
        var buf: String = ""
        for (i in pets.indices) {
            buf += pets[i].toString()
    }
        return buf
    }
}