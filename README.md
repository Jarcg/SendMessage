# 📱 SendMessage (`sendMenssage`)

Aplicación nativa para Android desarrollada en **Kotlin** que ilustra la arquitectura básica de navegación y paso de datos entre *Activities* utilizando `Intent` y `Bundle`, además de mejores prácticas de diseño en Android Studio, depuración con Logcat y exploración del sistema de archivos de la aplicación.

---

## 📸 Capturas de Pantalla en el Emulador (Obligatorio)

| Pantalla Principal (`SendMessageActivity`) | Pantalla de Visualización (`ViewMessageActivity`) |
| :----------------------------------------: | :-----------------------------------------------: |
| ![SendMessageActivity](docs/screenshots/send_message_activity.png) | ![ViewMessageActivity](docs/screenshots/view_message_activity.png) |
| *Ingreso del texto del mensaje y botón de envío* | *Recepción y despliegue del mensaje enviado* |

> 💡 **Flujo de Usuario**: El usuario escribe un texto en el campo `EditText` de la actividad principal. Al presionar el botón **Enviar**, se crea un `Intent` explícito con un `Bundle` que contiene el mensaje y navega a la segunda actividad para mostrarlo.

---

## 🏗️ Estructura del Proyecto y Decisiones de Diseño

### 📂 Estructura de Paquetes y Archivos

```text
sendMenssage/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/sendmenssage/
│   │   │   │   ├── SendMessageActivity.kt       # Actividad de origen: captura entrada e inicia el Intent
│   │   │   │   ├── ViewMessageActivity.kt       # Actividad de destino: recupera datos del Intent y muestra UI
│   │   │   │   └── SendMessageApplication.kt   # Clase Application personalizada
│   │   │   ├── res/
│   │   │   │   ├── font/                        # Fuentes tipográficas personalizadas (Emily Street, Original Surfer)
│   │   │   │   ├── layout/                      # Diseños XML (activity_send_message.xml, activity_view_message.xml)
│   │   │   │   ├── values/                      # Reutilización de strings.xml, colors.xml, dimens.xml
│   │   │   │   └── drawable/                    # Recursos gráficos e íconos vectoriales
│   │   │   └── AndroidManifest.xml              # Declaración de componentes e Intents de la app
│   └── build.gradle.kts                         # Configuración de compilación del módulo
├── docs/
│   └── screenshots/                             # Capturas de pantalla e imágenes para documentación
├── CHANGELOG.md                                 # Registro de cambios y versiones
└── README.md                                    # Documentación principal
```

### 🎨 Decisiones de Diseño e Interfaz

1. **Arquitectura basada en Actividades e Intents**:
   - Se eligió una navegación mediante `Intent` explícito (`Intent(this, ViewMessageActivity::class.java)`) para demostrar el desacoplamiento de pantallas y la transferencia de datos mediante clave-valor (`KEY_MESSAGE`).

2. **Diseño de Interfaz Responsivo (`LinearLayout` & Unidades)**:
   - Uso de `LinearLayout` vertical para estructurar los elementos ordenadamente de arriba a abajo.
   - **Dimensiones Adaptables**: Utilización estricta de `sp` para tamaños de fuentes (`tvTitle`, `iVMessageSize`) y `dp` para márgenes/espaciados, garantizando la correcta escalabilidad según las preferencias de accesibilidad del usuario.

3. **Tipografía y Estilo Visual**:
   - Integración de fuentes tipográficas personalizadas instaladas en `res/font/` (`emily_street.ttf` y `original_surfer_regular.ttf`) asociadas mediante la propiedad `android:fontFamily`.

4. **Accesibilidad e Internacionalización**:
   - Extracción de todas las cadenas de texto al archivo `res/values/strings.xml`.
   - Uso de atributos de accesibilidad como `android:hint` en campos de texto y `android:contentDescription` en componentes de imagen (`ImageView`).

---

## 🐛 Proceso de Depuración y Evidencias de Logcat (Obligatorio)

### 🔍 Flujo de Depuración en Android Studio

1. **Puntos de Interrupción (Breakpoints)**:
   - Se colocan *breakpoints* en el evento `setOnClickListener` de `SendMessageActivity.kt` para inspeccionar el valor capturado de `etMessageText.text.toString()`.
   - Evaluación en tiempo de ejecución del contenido del objeto `Bundle` antes de invocar `startActivity(intent)`.

2. **Seguimiento mediante Logcat**:
   - Filtrado en la ventana de **Logcat** de Android Studio mediante el paquete `package:mine` o `package:com.example.sendmenssage`.
   - Verificación de los ciclos de vida de las actividades (`onCreate`, `onStart`, `onResume`) y mensajes de depuración personalizados.

### 🖼️ Evidencia en Logcat
![Proceso de Depuración en Logcat](docs/screenshots/logcat_debugging.png)

---

## 📂 Acceso al Directorio `/data/data/` de la Aplicación

El directorio privado de la aplicación se encuentra en la memoria interna del sistema Android en la ruta:
```text
/data/data/com.example.sendmenssage/
```

### 🛠️ Exploración mediante Device File Explorer
A través de la herramienta **Device File Explorer** integrada en Android Studio o mediante ADB Shell (`adb shell` -> `run-as com.example.sendmenssage`), se puede acceder al almacenamiento interno privado de la app donde se gestionan:
- **`cache/`**: Archivos temporales.
- **`code_cache/`**: Archivos de caché compilados.
- **`shared_prefs/`**: Preferencias compartidas de la aplicación.
- **`databases/`**: Bases de datos SQLite / Room.

### 🖼️ Imagen del Explorador de Archivos en `/data/data/`
![Conexión al directorio /data/data/](docs/screenshots/data_data_explorer.png)

---

## 📚 Enlaces a la Documentación Oficial de Android Developer

Para mayor información sobre los componentes y conceptos utilizados en esta aplicación, consulta la documentación oficial de Android:

- 🔗 [Intents e Intent Filters](https://developer.android.com/guide/components/intents-filters)
- 🔗 [Ciclo de Vida de las Actividades (Activities)](https://developer.android.com/guide/components/activities/activity-lifecycle)
- 🔗 [Guía de Layouts y Vistas en XML](https://developer.android.com/guide/topics/ui/declaring-layout)
- 🔗 [Depuración y Registro con Logcat en Android Studio](https://developer.android.com/studio/debug/am-logcat)
- 🔗 [Explorador de Archivos del Dispositivo (Device File Explorer)](https://developer.android.com/studio/debug/device-file-explorer)
- 🔗 [Uso de Recursos Tipográficos en Android](https://developer.android.com/guide/topics/ui/look-and-feel/fonts-in-xml)

---

## 📄 Licencia y Créditos

Proyecto desarrollado para fines educativos y de demostración técnica en desarrollo Android nativo con Kotlin.
# SendMessage
