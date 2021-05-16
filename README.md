# lemon-challenge


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
              

## Model 
         
   
https://drive.google.com/file/d/196B1KSwdpf4Ju13RNYRyu1q30WFSdn89/view?usp=sharing -> para tener el link a mano
