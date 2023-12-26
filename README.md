## 📜 Summary
Conjunto de microservicios para la generación de Tickets para un evento.

Los clientes se gestionaran en el microservicio micro-tickets-clients que se crearan a partir de una llamada a un endpoint
remoto que proporciona dichos clientes.

Los eventos se generaran en el microservicio micro-ticket-events y por último
el microservicio de tickets será el encargado de crear un ticket a partir 
de un id de un cliente y un id de un evento.

Se podrá generar un código QR que nos debe apuntar a un endoint para validarlo.

## 📜 Base de datos
El sistema de base de datos elegido es un POSTGREE que contendrá las tablas necesarias
para almacenar clientes, eventos y tickets para esos eventos.
Se proporciona un fichero docker-compose para utilizar una imagen docker con un servidor de Postgree

En primer lugar se deberá arrancar la imagen docker de la base de datos Postgree
docker> docker-compose up -d

## 📜 Configuraciones
Cada microservicio intentará recuperar su configuracion desde el servidor de config-server. 
Los ficheros de configuración están en un repo ubicado en la carpeta
\config-tickets
- servicio-clients-dev.properties
- servicio-events-dev.properties
- servicio-tickets-dev.properties

Estarán conectados con el repo GITHUB :
https://github.com/zmonsanu/gestion-tikets-config.git
Cada cambio se deberá comitear para que el servidor config-server lo tenga en cuenta.
No es necesario realizar un PUSH al repo remoto.

## 📜 Puesta en marcha
Una vez puesta en marcha nuestra base de datos debemos arrancar los microservicios en este orden:
1) micro-servicio-eureka
2) micro-config-server
3) micro-servicio-api-gateway
4) micro-ticket-clients
5) micro-ticket-events
6) micro-ticket-tickets

En la pagina de Eureka se debe comprobar que estén arrancados los microservicios:
   http://localhost:8761/

## 📜 Endpoint para pruebas:
Creación de clientes:
POST http://localhost:8091/api/clients/createRemote

Obtencion de clientes:
GET http://lcoalhost:8091/api/clients/getall

Crear un evento:
POST http://localhost:8091/api/events/create
Parametros{description, location, production}

Obtener los eventos:
GET  http://localhost:8091/api/events/getall

Creacion de ticket para un evento:
POST  http://localhost:8091/api/tickets/create
Parametros {description, eventId, clientId, price}

Generar un código QR para un ticket:
POST  http://localhost:8091/api/tickets/generate?id=de8ff704-aac9-40a5-afc9-7c302b80e5e8
Las imagenes con el código QR se guardaran en la ruta qr dentro del proyecto micro-ticket-tickets

Validar un ticket:
POST  http://localhost:8091/api/tickets/validate?id=de8ff704-aac9-40a5-afc9-7c302b80e5e8