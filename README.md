# Prueba Técnica German Lizondo para Inditex

Versión Java: 11 <br>
Versión Gradle: 7.4

Comando de compilación: gradle clean build<br>
Comando de ejecución: java -jar build/libs/prueba-0.0.1-SNAPSHOT.jar

<h3>H2 DATABASE </h3>
<hr>
Se usa la base de datos H2,
además hay un archivo llamado data.sql que inserta los datos en la base de datos<br>
Para poder comprobar los datos mediante el gestor incorporado en h2:<br>

url: http://localhost:8080/h2-console <br>
driver class: org.h2.Driver<br>
jdbc url: jdbc:h2:mem:testdb <br>
user name: user<br>
password: user<br>

<h3>Endpoints </h3>
<hr>
Login curl: 

```
curl --location --request GET 'localhost:8080/price?dateApplied=2020/06/16 21:00:00&productId=35455&brandId=1' ''
```
Response:
```json
{
  "productId": 35455,
  "brandId": 1,
  "priceList": 4,
  "startDate": "2020-06-15 16:00:00.0",
  "endDate": "2020-12-31 23:59:59.0",
  "finalPrice": 38.95
}
```