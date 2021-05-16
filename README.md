# lemon-challenge

_Api encargada del manejo de Usuarios y creación de transacciones_

## pre-requerimientos
 * tener instalado cliente mySLQ v5.
   
   De no llegar a tenerlo, copiar el siguiente script en un archivo, guardarlo y luego correrlos por consola con el siguiente comando:  
   
```bash
    docker-compose up [nombre_archivo].yml
```
         
        # Use root/example as user/password credentials
        version: '3.1'

        services:

          db:
            image: mysql:5.7.26
            command: --default-authentication-plugin=mysql_native_password
            restart: always
            ports:
              - 3306:3306    
            volumes:
              - ~/mysql:/var/lib/mysql    
            environment:
              MYSQL_ALLOW_EMPTY_PASSWORD: "true
              
## Diagramas del modelo

### Model 
  ![alt text](https://user-images.githubusercontent.com/8374613/118416500-60276700-b686-11eb-8233-36d0f5e1d398.png)


### Diagrama secuencia
  ![alt text](https://user-images.githubusercontent.com/8374613/118416712-58b48d80-b687-11eb-8af0-302c8a1eaeac.png)
   
   ACLARACIÓN: el presente diagrama de secuencia no refleja exactamente la cantidad de clases que hay en el proyecto. Es para darse una idea de como se crean los objetos
  
   
### Proceso de creación tablas en ambiente local
   
   Una vez clonado el proyecto branch (main), en la ruta "src/main/resources/" habrá una carpeta con con los cripts sql a correr ya ordenados. Termiando esto, ya habrá dos usuarios de prueba creados en la tabla User
   

## Curls de prueba
   
   
   

