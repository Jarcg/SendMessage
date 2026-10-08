package com.example.sendmessage.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable
/**
 * # Clase Person
 *
 * Modelo de datos inmutable que representa a una persona emisora o receptora de un mensaje.
 *
 * @author Jacinto Rafael
 * @version 1.0.0
 * @property dni es el identificador único de la persona
 * @property name nombre de la persona
 * @property surname apellidos de la persona
 */
@Parcelize
data class Person (val dni: String, val name: String, val surname: String) : Parcelable {

}