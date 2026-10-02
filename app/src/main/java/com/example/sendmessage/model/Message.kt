package com.example.sendmessage.model

import android.widget.EditText
import  java.io.Serializable
data class Message (
    val id: Int,
    val content: String,
    val sender: Person,
    val receiver: Person
) : Serializable


// Mensaje [ id , cadena Persona que envie, Persona que recibe] Sector