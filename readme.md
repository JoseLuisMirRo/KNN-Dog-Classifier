# Proyecto de Clasificación de Perros usando el algoritmo KNN

Este proyecto es una aplicación web para la clasificación de perros utilizando Java, Spring Boot y JavaScript. La aplicación permite a los usuarios cargar un dataset y mediante un algoritmo de clasificación, predecir la raza de un perro a partir de sus características.

Proyecto integrador de la materia de Estructuras de Datos de la Universidad Tecnológica Emiliano Zapata del Estado de Morelos.
Utilizando el algoritmo KNN (K-Nearest Neighbors) para la clasificación de perros y las clases generadas durante el curso: 
- **1**: ArrayList personalizado.
- **2**: Bubble Sort personalizado.
## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **Spring Boot**: Framework para el desarrollo de aplicaciones web.
- **JavaScript**: Lenguaje de programación para la interacción en el lado del cliente.
- **Gradle**: Herramienta de automatización de compilación.
- **Apache POI**: Biblioteca para trabajar con archivos de Microsoft Office.

## Estructura del Proyecto

- `src/main/java`: Contiene el código fuente de la aplicación en Java.
- `src/main/resources/static`: Contiene los archivos estáticos como HTML, CSS y JavaScript.
- `build.gradle`: Archivo de configuración de Gradle.

## Configuración del Entorno

1. **Requisitos Previos**:
   - JDK 23
   - Gradle
   - IDE (IntelliJ IDEA recomendado)

En el mismo repositorio, se encuentra un archivo 'dataset_dog_breed_classifier.xlsm' que contiene un dataset de perros con sus características. 
Para cargar el dataset, se debe seleccionar el archivo y hacer clic en el botón 'Cargar Dataset'.

También se encuentra en el apartado de releases, un archivo 'dog_breed_classifier-0.0.1-SNAPSHOT.jar' que contiene la aplicación compilada. 
Para ejecutar la aplicación, haga doble clic en el archivo o ejecute el siguiente comando en la terminal:

```bash
java -jar dog_breed_classifier-0.0.1-SNAPSHOT.jar
```

Para acceder a la aplicación, abra un navegador web y vaya a la dirección `http://localhost:8080`.
