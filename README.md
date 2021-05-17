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
   
######   Creación de transacciones.

Las transacciones son de dos tipos:
   * MOVEMENT: movimiento entre dos usuarios. userFrom: id desde donde saca plata. userTo: usuario hacia donde iría. CurrencyType : BTC, ARS, USDT
   * DEPOSIT: deposito de dinero. userTo: id del usuario a depositar 
   
   ```curls
   curl --request POST \
  --url http://localhost:8080/lemon/challenge-api/transaction \
  --header 'Content-Type: application/json' \
  --data '{	
    "userFrom":"1",
    "userTo":"2",
    "amount":"0.000224342000",
    "currencyType":"BTC",
		"transactionType":"MOVEMENT"
}
'
```

 ```curls
curl --request POST \
  --url http://localhost:8080/lemon/challenge-api/transaction \
  --header 'Content-Type: application/json' \
  --data '{	
    "userTo":"1",
    "amount":"0.0002143420",
    "currencyType":"BTC",
		"transactionType":"DEPOSIT"
}
'
 ```

###### Creación de usuarios
Como dice el título, se crean usuarios, creando internamente tres billeteras
 ```curls
curl --request POST \
  --url http://localhost:8080/lemon/challenge-api/user \
  --header 'Content-Type: application/json' \
  --data '{
	"name" : "Dani",
  "lastName":"Ruibal",
  "alias":"Danilamas",
  "email":"dan@sarlanga.com"
}'
 ```

###### Búsqueda de usuarios por id

 ```curls
curl --request GET \
  --url http://localhost:8080/lemon/challenge-api/user/1
  ``` 

###### Búsqueda de transacciones por filter
   Este servicio tiene un filter el cual tiene 4 parametros no obligatorios:
   * limit: cantidad de resultados por página
   * offset: numero de pagina a buscar (comienza de 0)
   * transactionType: tipo de transacciones (MOVEMENT o DEPOSIT)
   * currencyType: ARS, BTC, USDT
   
   ```curls
  curl --request GET \
  --url 'http://localhost:8080/lemon/challenge-api/transaction?currencyType=BTC&transactionType=DEPOSIT&offset=0&limit=10'
   ```
   
   ```curls
  curl --request GET \
  --url http://localhost:8080/lemon/challenge-api/transaction
 ```
 
 
 
 ## Disclaimer
 
 Me quedaron un par de cosas a corregir como por ejemplo 
  * (el filtro pasarlo a query de hql)
  * el date de creation date deber{ia ser automatico me falta agregar configuración
  * seguramente me olvido de algo
 
