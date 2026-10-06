package com.example.sendmessage

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.sendmessage.model.Message

class ViewMessageActivity : AppCompatActivity() {
    companion object{
        const val TAG: String = "LogViewMessageActivity" //De esta manera podemos cambiarlo de forma más cómoda y sin tener duplicados.
    }
    @RequiresApi(Build.VERSION_CODES.TIRAMISU) //Lo implementa el IDEA para que funcione el serializer.
    /**
     * Método llamado al crear la actividad. Se encarga de inicializar la interfaz de usuario,
     * enlazar los componentes visuales y configurar los eventos de clic.
     *
     * Como medida de aprendizaje, aquí se muestra cómo pasar datos dato a dato utilizando un [Bundle]:
     * ```kotlin
     * val intent = Intent(this, ViewMessageActivity::class.java)
     * val bundle = Bundle()
     * bundle.putString("KEY_MESSAGE", etMessageText.text.toString())
     * intent.putExtras(bundle)
     * startActivity(intent)
     * ```
     *
     * @param savedInstanceState Estado guardado previamente de la actividad, si lo hubiera. (Probando comentarios con IA como dijimos en clase)
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_view_message)

        val tvTitleView = findViewById<TextView>(R.id.tvTitleView) //Gracias a esto podemos acceder a las propiedades del tvTitleView.
        val tvTittleContentView = findViewById<TextView>(R.id.tvTittleContentView) //Gracias a esto podemos acceder a las propiedades del tvTittleContentView.
        val bundle = this.intent.extras //Lo que hacemos es recoger el bundle del intent que ya lo tenemos pasado.
       //val message = bundle?.getSerializable("KEY_MESSAGE", Message::class.java) //Serializamos, comprobando que si es nulo no lo haga para no comernos una excepción.
        //Lo recogemos
        //val emisor = message?.sender
        //val receptor = message?.receiver
        //val contenido = message?.content
        //Le asignamos el texto a la vista.
        //tvTitleView.text = emisor?.name.toString()
        //tvTittleContentView.text = contenido
        val message = bundle?.getParcelable("KEY_MESSAGE", Message::class.java)
        val emisor = message?.sender
        val receptor = message?.receiver
        val contenido = message?.content
        //Le asignamos el texto a la vista.
        tvTitleView.text = emisor?.name.toString()
        tvTittleContentView.text = contenido


    }
    //region Ciclo de Vida de una Actividad
    override fun onStart() {
        super.onStart()
        Log.d(TAG,"ViewMessageActivity -> onStart()")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"ViewMessageActivity -> onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"ViewMessageActivity -> onDestroy()")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"ViewMessageActivity -> onResume()")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"ViewMessageActivity -> onPause()")

    }
    //endregion
}