package com.example.sendmessage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.sendmessage.model.Message
import com.example.sendmessage.model.Person
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * Esto es la primera actividad de la aplicación que realiza la operaciones:
 * <ol>
 *     <li>Crear un componente <code> EditText</code> y Button en XML</li>
 *     <li>Crear el <code>Intent</code> con el <code>Bundle</code> para pasar a otra actividad</li>
 *     <li>El ciclo de vida de la Activity </li>
 *     <li> Ver la pila de Actividades </li>
 * </ol>
 *
 * @author Jacinto Rafael Cortés
 * @version 1.0
 * @see android.widget.EditText
 * @see Bundle
 * @see Intent
 */


class SendMessageActivity : AppCompatActivity() {
    //Solo se puede inicializar aquí para que lo tenga toda la clase
    //Lo que dice es que la inicialización será posterior
    lateinit var etMessageText : EditText
    lateinit var btSend: FloatingActionButton //Gracias a esto podemos incrustar imágenes en el botón, si hubiéramos puesto button no podríamos.
    //Esto es un objeto singleton sirve para hacer algo común y no duplicar.
    companion object{
        const val TAG: String = "LogSendMessageActivity"
    }
    /**
     * Método de creación de una actividad.
     * @param Bundle
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_message) //Estamos asignando un layout a la vista
        //Se obtiene el objeto view de la vista que se ha inflado.
        etMessageText = findViewById(R.id.etMessageText)
        btSend = findViewById(R.id.btsend)

        /*
             btSend.setOnClickListener {

                 Es como escribir el nombre del destinatario
                 val intent = Intent(this, ViewMessageActivity::class.java)
                 Este es lo que quieres meter las cosas en el sobre
                 val bundle = Bundle()
                 bundle.putString("KEY_MESSAGE",etMessageText.text.toString())
                 Le agregamos el objeto
                 intent.putExtras(bundle)
                 //Se lo enviamos
                 startActivity(intent)



        }

         */
        btSend.setOnClickListener {
            sendMessage()
        }

    }
    /*
    Función que crea un mensaje con la información de la persona que envía y de la persona
    que debe recoger el mensaje
     */
    private fun sendMessage(){
        //1. Crear el Intent
        val intent = Intent(this, ViewMessageActivity::class.java)
        val bundle = Bundle()
        val sender = Person("1223113D", "María","Cortés Martín")
        val receiver = Person("98838283D","Lourdes","Rodriguez")

        val message = Message(1,etMessageText.text.toString(),sender,receiver)

        //No es recomendable
        bundle.putSerializable("KEY_MESSAGE",message)
        intent.putExtras(bundle)
        startActivity(intent)
        //Que se envíe este mensaje de maria con el nombre y la información
    }
    //region Ciclo de Vida de una Actividad
    override fun onStart() {
        super.onStart()
        Log.d(TAG,"SendMessageActivity -> onStart()")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"SendMessageActivity -> onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"SendMessageActivity -> onDestroy()")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"SendMessageActivity -> onResume()")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"SendMessageActivity -> onPause()")

    }
    //endregion
    //Cosas que hemos hecho:
    // Crear component objet y serializar y parcelar
    //serializar se envía de bit a bit
}