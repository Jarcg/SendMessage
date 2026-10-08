# Changelog

Todas las modificaciones notables realizadas en este proyecto serán documentadas en este archivo.

El formato está basado en [Keep a Changelog](https://keepachangelog.com/es-ES/1.0.0/) y este proyecto adhiere a [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

---

## [Unreleased]

### Añadido
- Documentación inicial del repositorio mediante archivos `README.md` y `CHANGELOG.md`.
- **`AGENTS.md`**: archivo de instrucciones para agentes de IA (OpenCode) con la estructura de directorios, comandos exactos de Gradle (build, lint, tests, Dokka), distinción `namespace` (`com.example.sendmessage`) vs. `applicationId` (`com.example.sendmenssage`), flujo de navegación `Intent`/`Bundle` (`KEY_MESSAGE`), restricción de probar en API 33+, notas del flujo de documentación en GitHub Pages y convenciones del repositorio (idioma español, skills en `.opencode/skills/`).
- **Internacionalización (i18n)**: traducción al inglés de las cadenas de la interfaz en `app/src/main/res/values-en/strings.xml`, manteniendo el español como idioma base por defecto en `app/src/main/res/values/strings.xml` (mismos nombres de recurso en ambos archivos).

---

## [1.0.0] - 2026-09-27

### Añadido
- **`SendMessageActivity`**: Pantalla principal con campo de edición (`EditText`) y botón de envío (`Button`).
- **`ViewMessageActivity`**: Pantalla secundaria para mostrar el mensaje enviado.
- Navegación entre vistas mediante `Intent` explícito y paso de parámetros utilizando `Bundle` (`KEY_MESSAGE`).
- Recursos tipográficos personalizados en `res/font/`:
  - `emily_street.ttf`
  - `original_surfer_regular.ttf`
- Recursos de diseño XML:
  - Layout `activity_send_message.xml`
  - Layout `activity_view_message.xml`
- Configuración de dimensiones (`dimens.xml`) y colores (`colors.xml`).
- Configuración básica en `AndroidManifest.xml` con ajuste de teclado virtual (`windowSoftInputMode="adjustResize"`).

### Modificado
- Corrección del ID del componente `TextView` en `activity_view_message.xml` (`tvTitleView`).
- Ajuste del tamaño de dimensión `iVMessageSize` a `80sp` en `dimens.xml`.
