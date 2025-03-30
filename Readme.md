# API de Tareas

## Descripción
API REST para gestión de Tareas, construida con Spring Boot e Hibernate.

## Tecnologías Utilizadas
- **Java 17**
- **Spring Boot 3.4.4**
- **Spring Data JPA**
- **Lombok - para codigo limpio**
- **MySQL**
- **Swagger (Springdoc OpenAPI 2)**
- **Docker & Docker Compose**

## Estructura del Proyecto
El proyecto se construye con la siguiente arquitectura:

- **Dominio**: Modelos y Repositorios
- **Aplicación**: Servicios y lógica de negocio
- **Infraestructura**: Controladores y configuración
- **Pruebas Unitarias**: Test con Mockito

## Instalación y Ejecución

### Requisitos Previos
- Java 17
- Maven
- Docker (Se puede ejecutar también con Docker Compose)

### Configuración del Entorno
Se deben configurar las variables de conexión a la base de datos en `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/api?serverTimezone=UTC
server.port=1234
spring.datasource.username=root
spring.datasource.password=
```

### Construcción y Ejecución

#### Con Maven:
```sh
mvn clean package
java -jar target/api.jar
```

#### Con Docker:
```sh
docker-compose up --build
```

## Endpoints Disponibles

| Método  | Endpoint           | Descripción                     |
|---------|--------------------|---------------------------------|
| GET     | `/api/tareas`      | Obtener todas las tareas        |
| GET     | `/api/tareas/{id}` | Obtener una tarea por ID        |
| POST    | `/api/tareas`      | Crear una nueva tarea           |
| PUT     | `/api/tareas/{id}` | Actualizar una tarea existente  |
| DELETE  | `/api/tareas/{id}` | Eliminar una tarea              |

## Documentación Swagger
Después de iniciar la aplicación, se puede acceder a la documentación Swagger en:
```
http://localhost:1234/swagger-ui/index.html
```

## Pruebas Unitarias
Para ejecutar las pruebas unitarias con JUnit y Mockito se deben correr los siguientes comandos:
```sh
mvn test  # Si usas Maven

```

## Despliegue en la Nube
El sistema está diseñado para ser desplegado en plataformas como AWS, GCP o Azure usando contenedores Docker y bases de datos gestionadas.

---
**Desarrollado por**: Carlos Felipe Dominguez Ilera