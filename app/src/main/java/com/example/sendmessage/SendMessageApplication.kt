package com.example.sendmessage

import android.app.Application

/**
 * Aplicación personalizada: punto de entrada global del proceso antes de crear cualquier actividad.
 *
 * Declarada en `AndroidManifest.xml` con `android:name=".SendMessageApplication"` para
 * inicializar componentes de alcance global (contexto, configuración, dependencias).
 */
class SendMessageApplication : Application() {

}