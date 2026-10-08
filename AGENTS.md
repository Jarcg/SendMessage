# AGENTS.md

Proyecto Android educativo en Kotlin: dos Activities conectadas por `Intent` + `Bundle` (objeto `Parcelable`). Un solo módulo Gradle (`:app`). No hay backend, ni CI de build/test: el único workflow publica documentación.

## Estructura de directorios

```text
sendMenssage/
├── app/src/main/java/com/example/sendmessage/   # código fuente (nombre del namespace, NO del applicationId)
│   ├── SendMessageActivity.kt                   # LAUNCHER: captura el texto y lanza el Intent
│   ├── ViewMessageActivity.kt                   # destino: lee KEY_MESSAGE del Bundle
│   ├── SendMessageApplication.kt                # clase Application (declarada en el manifest)
│   └── model/Message.kt · Person.kt             # data classes @Parcelize
├── app/src/main/res/
│   ├── layout/                                  # UI real (XML); activity_send_message.xml, activity_view_message.xml
│   ├── values*/                                 # values, values-en, values-night, values-land, values-w*, values-v23
│   ├── font/ · drawable/ · navigation/ · xml/   # fuentes, gráficos, grafo de navegación (sin usar), reglas de backup
├── app/src/main/AndroidManifest.xml             # componentes e Intent filters
├── app/src/test/ · app/src/androidTest/         # solo tests plantilla (JUnit 4 / Espresso)
├── gradle/libs.versions.toml                    # catálogo de versiones: aquí se añaden dependencias
├── documentation/html/                          # Dokka GENERADO, versionado en git → GitHub Pages
├── docs/screenshots/                            # capturas que enlaza el README
├── resource/                                    # assets auxiliares (SVG, fuentes originales, imágenes de marca)
├── .github/workflows/desplegar-dokka.yml        # único workflow del repo
├── .opencode/skills/                            # skills locales de OpenCode
├── settings.gradle.kts · build.gradle.kts · gradle.properties
└── README.md · CHANGELOG.md · AGENTS.md
```

> Nota: los directorios `build/` y `app/build/` son artifacts de compilación (en `.gitignore`); `documentation/html/` en cambio sí está commiteado.

## Comandos (usar el wrapper, nunca un Gradle global)

```bash
./gradlew assembleDebug          # APK debug → app/build/outputs/apk/debug/
./gradlew lintDebug              # Android Lint (no hay ktlint/detekt/spotless en el repo)
./gradlew test                   # Unit tests (JUnit 4, plantillas en app/src/test/)
./gradlew connectedDebugAndroidTest  # Instrumentación: requiere emulador/dispositivo
./gradlew dokkaGenerate          # KDoc → documentation/html/ (ver "Documentación")
```

Un solo test:

```bash
./gradlew :app:testDebugUnitTest --tests "com.example.sendmessage.ExampleUnitTest"
```

Verificación mínima recomendada antes de dar un cambio por bueno: `./gradlew lintDebug test assembleDebug`. Solo existen los tests plantilla (`ExampleUnitTest`, `ExampleInstrumentedTest`); no hay fixtures ni servicios externos.

Requisitos: JDK 11+ (el toolchain se resuelve solo vía foojay-resolver); el CI de docs usa Java 17. `local.properties` (ruta del SDK) es local y está en `.gitignore`. `org.gradle.configuration-cache=true` está activo: si la configuración queda rancia tras tocar `*.gradle.kts`, borra `.gradle/configuration-cache` o reinicia con `--no-configuration-cache`.

## Identidad (fácil de confundir)

- `namespace` y paquete de código fuente: `com.example.sendmessage`
- `applicationId` publicado: `com.example.sendmenssage` (**con "s" — el typo es intencional**, así que el paquete real de la app instalada y los filtros de Logcat usan esa forma).
- Al añadir repositorios: `settings.gradle.kts` fija `RepositoriesMode.FAIL_ON_PROJECT_REPOS`; solo se pueden declarar repos ahí, no en módulos.

## Arquitectura y flujo real

- Entrada: `SendMessageActivity` (LAUNCHER) → `sendMessage()` construye `Intent` explícito + `Bundle` con `bundle.putParcelable("KEY_MESSAGE", Message)` → `ViewMessageActivity` lo lee con `bundle.getParcelable("KEY_MESSAGE", Message::class.java)`.
- `SendMessageApplication` es la `Application` declarada en el manifest.
- Modelos `Message` y `Person` en `app/src/main/java/com/example/sendmessage/model/` usan `@Parcelize` (plugin `kotlin-parcelize`). La clave `KEY_MESSAGE` es el único contrato entre pantallas — cámbiala en ambos extremos.
- **La UI es 100 % XML + `findViewById`** (`setContentView`). View Binding y Compose están habilitados en `app/build.gradle.kts` pero la UI actual no los usa: no conviertas pantallas a Compose sin que se pida. Navigation-ktx también está incluido y sin usar.
- Muchos bloques de código educativo están comentados a propósito (versiones antiguas con `putString`/`putSerializable`); son material de clase, no basura que limpiar.

## Gotcha de API: probar en API 33+

`minSdk = 24`, pero `ViewMessageActivity.onCreate` está anotada `@RequiresApi(TIRAMISU)` y usa la sobrecarga `Bundle.getParcelable(key, Class)` (API 33) **sin guardia de versión**: la app crashea en dispositivos con Android < 13. Usa un emulador API 33+ para pruebas manuales.

## Documentación (Dokka) y CI

- `./gradlew dokkaGenerate` escribe en `documentation/html/` (ruta fijada en `app/build.gradle.kts`, no la default de Dokka).
- `documentation/html/` está **versionado en git**; el workflow `.github/workflows/desplegar-dokka.yml` lo regenera y despliega a GitHub Pages en cada push a `main`. No hay ningún otro workflow: los cambios no se validan en CI, verifica localmente.
- El README es extenso y a veces describe intenciones ("incluida, no usada") en vez de estado real; ante discrepancia, manda el código/Gradle.

## Convenciones del repo

- Código, comentarios, docs y workflows están en **español**; mantener ese idioma al documentar.
- **i18n de strings**: el idioma base (que usa el sistema por defecto) es el **español**, en `res/values/strings.xml`; la traducción vive en `res/values-en/strings.xml` (es el único locale traducido). Al añadir o modificar una cadena, hazlo en **ambos archivos con el mismo `name`**.
- Skills locales de OpenCode en `.opencode/skills/`: `personalice-docs-generator` (generar KDoc/README) y `generar-fichero-license` (crear LICENSE). Invocarlas cuando la tarea coincida en vez de improvisar el formato.
