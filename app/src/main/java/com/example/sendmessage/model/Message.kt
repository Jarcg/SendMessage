package com.example.sendmessage.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
/**
* # Clase Message
* ---
*@author Jacinto Rafael
* @version 1.0.0
* ---
* Contenido
* - @property id es el identificador único del mensaje
* - @property String es el contenido del mensaje
* - @property sender la persona que envía el mensaje
* - @property receiver la persona que recibe el mensaje
* ---
* */
@Parcelize
data class Message (
    val id: Int,
    val content: String,
    val sender: Person,
    val receiver: Person
) : Parcelable


// Mensaje [id, cadena Persona que envíe, Persona que recibe] Sector