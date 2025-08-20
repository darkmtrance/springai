# Spring AI Demo Project

Este proyecto demuestra la integración de Spring AI con modelos de lenguaje de gran escala, ofreciendo diversas funcionalidades para generar respuestas, gestionar memoria de conversaciones, y utilizar herramientas personalizadas.

## Requisitos

- Java 17
- Maven 3.8+
- Ollama (modelo qwen2.5)

## Tecnologías

- Spring Boot 3.5.4
- Spring AI 1.0.1
- Spring Web

## Configuración

El proyecto está configurado para usar Ollama como modelo LLM predeterminado. Esto se configura en `application.properties`:

```properties
spring.ai.ollama.chat.model=qwen2.5
```

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── matomaylla/
│   │           └── springai/
│   │               ├── controller/
│   │               │   ├── ChatController.java
│   │               │   ├── FunctionController.java
│   │               │   ├── MemoryController.java
│   │               │   ├── PromptController.java
│   │               │   └── StructureOutputController.java
│   │               ├── tools/
│   │               │   └── DateTools.java
│   │               └── SpringaiApplication.java
│   └── resources/
│       └── application.properties
```

## Funcionalidades

### 1. Chat Básico
Implementado en `ChatController.java`, permite:
- Obtener respuestas simples del modelo LLM
- Recibir la respuesta completa con metadatos

Endpoints:
- GET `/chat?message=texto` - Devuelve solo el contenido textual de la respuesta
- GET `/chatResponse?message=texto` - Devuelve la respuesta completa con metadatos

### 2. Funciones y Herramientas
Implementado en `FunctionController.java` y `DateTools.java`, demuestra:
- Integración de herramientas personalizadas con modelos LLM
- Uso de anotaciones `@Tool` para definir herramientas

Endpoints:
- GET `/function` - Ejemplo que muestra la fecha actual usando herramientas

### 3. Memoria de Conversación
Implementado en `MemoryController.java`, permite:
- Mantener contexto entre mensajes de una conversación
- Utilizar `MessageWindowChatMemory` para almacenar historial

Endpoints:
- GET `/memory?message=texto` - Mantiene contexto entre llamadas sucesivas

### 4. Prompts con Sistema
Implementado en `PromptController.java`, demuestra:
- Uso de mensajes del sistema para definir el comportamiento del modelo
- Personalización de prompts con parámetros

Endpoints:
- GET `/post/new?topic=tema` - Genera un mini blog técnico sobre el tema especificado

### 5. Salida Estructurada
Implementado en `StructureOutputController.java`, permite:
- Obtener respuestas del modelo en formato estructurado (JSON)
- Mapear respuestas a objetos Java

Endpoints:
- GET `/structureOutput` - Retorna un itinerario de actividades en Lima estructurado

## Ejecución

Para ejecutar el proyecto:

```bash
mvn spring-boot:run
```

O si ya está compilado:

```bash
java -jar target/springai-0.0.1-SNAPSHOT.jar
```

## Ejemplos de Uso

### Ejemplo de Chat Básico
```
GET http://localhost:8080/chat?message=¿Qué es Spring AI?
```

### Ejemplo de Memoria
```
GET http://localhost:8080/memory?message=Me llamo Juan
GET http://localhost:8080/memory?message=¿Cómo me llamo?
```

### Ejemplo de Generación de Blog
```
GET http://localhost:8080/post/new?topic=Microservicios
```

## Recursos Adicionales

- [Documentación de Spring AI](https://docs.spring.io/spring-ai/reference/index.html)
- [Documentación de Ollama](https://ollama.com/docs)
