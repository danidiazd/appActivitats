## appActivitats-PruebaHackaton

<hr>

### Tabla de contenidos

1. [Descripción](#descripción)
2. [Uso](#uso)
3. [Instalación](#instalación)
    1. [Programas requeridos](#programas-requeridos)
    2. [Project links](#project-links)
    3. [Procedimiento](#procedimiento)
        1. [Procedimiento con Gradle](#procedimiento-con-gradle)
        2. [Procedimiento con Docker](#procedimiento-con-docker)

<hr>

### Descripción
Este proyecto appActivitats-PruebaHackaton está construido con Java con el framework Spring Boot. Es una iniciativa diseñada para gestionar usuarios y actividades, proporcionando una API integral para diversas operaciones.
El objetivo principal es proporcionar un servicio backend robusto para gestionar registros de usuarios, gestión de actividades e importación/exportación de datos en formato JSON.

### Uso
Este proyecto proporciona servicios de API REST para gestionar usuarios y actividades. Cada servicio expone API REST para interactuar con él. Para utilizar cualquier servicio, puede consultar la sección [procedimiento](#procedimiento) o iniciarlo desde la clase App en su IDE.

### Instalación

#### Programas requeridos
Es importante asegurarse de tener todas estas herramientas instaladas y configuradas correctamente antes de comenzar a trabajar en el proyecto.

- **Java SE Development Kit 21**
- **Gradle .0 or higher**
- **IntelliJ IDEA 2024.1.4 (or any other preferred IDE)**
- **Docker**
- **Postman**


#### Project links

- [GitHub](https://github.com/danidiazd/appActivitats).  El codigo fuente.
- [Swagger](http://localhost:8080/swagger). API documentación.

#### Procedimiento
1. Instale el software requerido que se encuentra en las secciones "Programas requeridos" y "Enlaces del proyecto".

2. Asegúrese de tener Docker Desktop encendido.

3. Abra MongoDB y cree la base de datos:
   - Abra una terminal y inicie el servidor MongoDB:
   ```sh
   mongod
   ```
   - Abra otra terminal y conéctese al servidor MongoDB:
   ```sh
   mongo
   ```
   - Cree la base de datos:
   ```sh
   use appActivitats
   ```
   - Cree las colecciones:
   ```sh
   db.createCollection("users")
   db.createCollection("activities")
   ```

4. Clone el repositorio:
   ```sh
   git clone https://github.com/danidiazd/appActivitats.git
    ```
5. Navegue hasta el directorio del proyecto:
   ```sh
    cd appActivitats\appActivitats\
   ```
##### 6. Procedimiento con Gradle
1. Compile el proyecto:

      ```sh
      gradle build
      ```
      Si está utilizando Windows PowerShell o Linux, puede usar el siguiente comando:
      ```sh
       ./gradlew build
    ```
2. Ejecute el proyecto:
   ```sh
   gradle bootRun
   ```
    Si está utilizando Windows PowerShell, Linux, puede usar el siguiente comando:
   ```sh
    ./gradlew bootRun
    ```
   
 ##### 6. Procedimiento con Docker
1. Construya el proyecto:
   ```sh
   gradle build
   ```
   Si está utilizando Windows PowerShell o Linux, puede usar el siguiente comando:
   ```sh
    ./gradlew build
    ```
2. Contruye la imagen con Docker compose:
    ```sh
    docker-compose up --build
    ```
   
7. Abra su navegador y navegue hasta [Swagger](http://localhost:8080/swagger) para ver la documentación de la API.
8. Utilice Postman para probar los puntos finales de la API.

##### Importe la colección de Postman desde la siguiente ruta:

```sh
    appActivitats/src/main/resources/postman/appActivitats.postman_collection.json
```
10. Para detener el proyecto, presione `Ctrl + C` en la terminal.






