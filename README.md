# Autor: Ángel Eduardo Hernández López
# Fecha: 11/04/2025  

# 1. IDE

    Se utilizó visual studio code 2022 con las extenciones:
        - Extension Pack for Java
        - Spring Boot Extension Pack
        - Maven for Java
        - Lombok Annotations Support for VS Code

# 2. Versión de lenguaje de programación

    Se utilizó java como lenguaje principal integrado con spring boot
    Se trabajó la parte de las vistas con JavaServer Pages (JSP).

# 3. DBMS utilizado y su versión

    Se trabajó con SQL Sever 2022 (RTM) 16.0.1.1000.6 - Developer Edition 64-bit 
    con el DBMS Sql Server Management Studio 20

# 4. Lista de pasos para correr la aplicación

    REQUISITOS
    - Java 21 (JDK)
    - Maven
    - Spring boot 3.4.4
    - Sql Server 2022
    - Git

    PASOS
    1. Clonar el repositorio 
        - Correr el siguiente comando en tu terminal de git
        git clone https://github.com/BitingSet560/InventarioCastores.git

    2. Correr script de bd
        - En tu servidor de sql correr el script llamado ScriptBD.sql que esta en
         la carpeta SCRIPTS en la raiz del proyecto

    3. Modificar el archivo application.properties
        - Desde la raiz del proyecto ingresar a src/main/resources/application.properties y cambiar:
          + spring.datasource.url (Por tu propia url de base de datos local)
          + spring.datasource.username (Por el usuario creado en tu base de datos con permisos de 
                                        creación, modificacion y eliminación)
          + spring.datasource.password (Por la contraseña de tu usuario)
    
    4. Ejecutar la aplicación
        -Desde el IDE:
            + Ingresar al apartado de Spring Boot Dashboard (A la izquierda de visual studio 2022)
            + Arriba a la derecha vendrá el nombre del proyecto con un botton de run (▶️)

        -Desde terminal:
            + Ingresar el siguiente comando:   
                mvn spring-boot:run
        
    5. Ir al navegador 
        - Ingresar al navegador con la siguiente ruta:
            + http://localhost:8080/login
            