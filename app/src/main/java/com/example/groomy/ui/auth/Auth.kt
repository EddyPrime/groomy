package com.example.groomy.ui.auth

object Auth {

    private val users = hashMapOf<String, String>()

    fun populateUsers() {
        users.put("mario@gmail.com", "123")
        users.put("luigi@gmail.com", "456")
        users.put("matteo@gmail.com", "abc")
        users.put("giordy@gmail.com", "def")
        users.put("eddy@gmail.com", "ghi")
    }

}