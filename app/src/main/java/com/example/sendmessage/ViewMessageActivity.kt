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
        const val TAG: String = "LogViewMessageActivity"
    }
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
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
     * @param savedInstanceState Estado guardado previamente de la actividad, si lo hubiera.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_view_message)

        val tvTitleView = findViewById<TextView>(R.id.tvTitleView)
        val tvTittleContentView = findViewById<TextView>(R.id.tvTittleContentView)
        val bundle = this.intent.extras
        val message = bundle?.getSerializable("KEY_MESSAGE", Message::class.java)
        val emisor = message?.sender
        val receptor = message?.receiver
        val contenido = message?.content
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