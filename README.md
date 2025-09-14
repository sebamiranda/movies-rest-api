# 🎬 Movies REST API

<div align="center">
  <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/Spring_Boot-3.5.5-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring Boot">
  <img src="https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL">
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white" alt="Maven">
</div>

<div align="center">
  <h3>🚀 API REST basica para gestión de películas</h3>
  <p>Desarrollada con Spring Boot, JPA/Hibernate y MySQL </p>
  
  [![GitHub stars](https://img.shields.io/github/stars/sebamiranda/movies-rest-api?style=social)](https://github.com/sebamiranda/movies-rest-api/stargazers)
  [![GitHub forks](https://img.shields.io/github/forks/sebamiranda/movies-rest-api?style=social)](https://github.com/sebamiranda/movies-rest-api/network)
</div>

---

## 🌟 Características Principales

- ✅ **CRUD Completo** - Operaciones Create, Read, Update, Delete
- ✅ **Arquitectura REST** - Endpoints siguiendo principios RESTful
- ✅ **Spring Data JPA** - Mapeo objeto-relacional con Hibernate
- ✅ **Validación de Datos** - Validaciones robustas de entrada
- ✅ **Configuración Flexible** - Variables de entorno para diferentes ambientes
- ✅ **Manejo de Errores** - Respuestas de error estructuradas y consistentes

## 🛠️ Stack Tecnológico

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| **Java** | 21 | Lenguaje de programación principal |
| **Spring Boot** | 3.5.5 | Framework para aplicaciones web |
| **Spring Data JPA** | - | Abstracción de acceso a datos |
| **Hibernate** | 6.6.26 | ORM para mapeo objeto-relacional |
| **MySQL** | 8.0 | Base de datos relacional |
| **Maven** | - | Gestión de dependencias y build |
| **NetBeans IDE** | 27 | Entorno de desarrollo |

## 📊 Modelo de Datos

```java
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private int year;
    private double rating;
    private int votes;
    
    @Column(name = "image_url")
    private String imageUrl;
}
```

### Ejemplo JSON:
```json
{
  "id": 1,
  "title": "The Matrix",
  "year": 1999,
  "rating": 8.7,
  "votes": 1500000,
  "imageUrl": "https://example.com/matrix.jpg"
}
```

## 🚀 Instalación y Configuración

### Prerequisitos
```bash
Java 21+
MySQL 8.0+
Maven 3.6+
Git
```

### Pasos de Instalación

1. **Clonar el repositorio**
```bash
git clone https://github.com/sebamiranda/movies-rest-api.git
cd movies-rest-api
```

2. **Crear base de datos**
```sql
CREATE DATABASE movies CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

3. **Configurar variables de entorno** (opcional)
```bash
export DB_USERNAME=root
export DB_PASSWORD=tu_password
```

4. **Configurar application.properties**
```properties
# Base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/movies
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD:root}

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

5. **Compilar y ejecutar**
```bash
mvn clean install
mvn spring-boot:run
```

🎉 **La API estará disponible en:** `http://localhost:8080`

## 📡 Endpoints de la API

### Base URL: `http://localhost:8080/api/movies`

| Método | Endpoint | Descripción | Código de Estado |
|--------|----------|-------------|------------------|
| `GET` | `/api/movies` | Obtener todas las películas | 200 OK |
| `GET` | `/api/movies/{id}` | Obtener película por ID | 200 OK / 404 Not Found |
| `POST` | `/api/movies` | Crear nueva película | 201 Created |
| `PUT` | `/api/movies/{id}` | Actualizar película completa | 200 OK / 404 Not Found |
| `DELETE` | `/api/movies/{id}` | Eliminar película | 204 No Content / 404 Not Found |

### Ejemplos de Uso

#### Crear Nueva Película
```bash
POST /api/movies
Content-Type: application/json

{
  "title": "Inception",
  "year": 2010,
  "rating": 8.8,
  "votes": 2000000,
  "imageUrl": "https://example.com/inception.jpg"
}
```

#### Obtener Todas las Películas
```bash
GET /api/movies

Response: 200 OK
[
  {
    "id": 1,
    "title": "The Matrix",
    "year": 1999,
    "rating": 8.7,
    "votes": 1500000,
    "imageUrl": "https://example.com/matrix.jpg"
  }
]
```

#### Actualizar Película
```bash
PUT /api/movies/1
Content-Type: application/json

{
  "title": "The Matrix Reloaded",
  "year": 2003,
  "rating": 7.2,
  "votes": 800000,
  "imageUrl": "https://example.com/matrix2.jpg"
}
```

## 🧪 Pruebas con Postman

### Colección de Postman
Importa esta colección para probar todos los endpoints:

```json
{
  "info": {
    "name": "Movies REST API",
    "description": "Colección completa para probar la API de películas"
  },
  "item": [
    {
      "name": "Obtener todas las películas",
      "request": {
        "method": "GET",
        "url": "{{baseUrl}}/api/movies"
      }
    },
    {
      "name": "Obtener película por ID",
      "request": {
        "method": "GET",
        "url": "{{baseUrl}}/api/movies/1"
      }
    },
    {
      "name": "Crear nueva película",
      "request": {
        "method": "POST",
        "url": "{{baseUrl}}/api/movies",
        "header": [
          {
            "key": "Content-Type",
            "value": "application/json"
          }
        ],
        "body": {
          "raw": "{\n  \"title\": \"Test Movie\",\n  \"year\": 2024,\n  \"rating\": 9.0,\n  \"votes\": 100000,\n  \"imageUrl\": \"https://test.com/image.jpg\"\n}"
        }
      }
    }
  ],
  "variable": [
    {
      "key": "baseUrl",
      "value": "http://localhost:8080"
    }
  ]
}
```

## 🏗️ Arquitectura del Proyecto

```
src/main/java/com/seba/movies/
├── 📁 MoviesApplication.java        # Clase principal de Spring Boot
├── 📁 controllers/
│   └── MovieController.java         # Controladores REST
├── 📁 models/
│   └── Movie.java                   # Entidades JPA
├── 📁 repositories/
│   └── MovieRepository.java         # Repositorios de datos
└── 📁 resources/
    └── application.properties       # Configuración de la aplicación
```

### Principios de Diseño
- **Separation of Concerns** - Separación clara de responsabilidades
- **RESTful Design** - APIs siguiendo principios REST
- **Dependency Injection** - Gestión automática de dependencias con Spring
- **Repository Pattern** - Abstracción de acceso a datos
- **Configuration Management** - Configuración externalizada

## 🎯 Roadmap - Próximas Mejoras

### 🔄 En Desarrollo
- [ ] **Paginación y Ordenamiento** - Implementar `Pageable` para grandes datasets
- [ ] **Filtrado Avanzado** - Búsqueda por título, año, rating
- [ ] **Validaciones Personalizadas** - Validadores para año y rating

### 🚀 Futuras Versiones
- [ ] **Autenticación JWT** - Sistema de autenticación y autorización
- [ ] **Documentación Swagger/OpenAPI** - API docs interactiva
- [ ] **Tests Unitarios e Integración** - Cobertura completa con JUnit 5
- [ ] **Docker & Docker Compose** - Containerización de la aplicación
- [ ] **CI/CD Pipeline** - GitHub Actions para deploy automático
- [ ] **Caching con Redis** - Mejora de performance
- [ ] **Logging Estructurado** - Logs con Logback y formato JSON

### 🔧 Optimizaciones Técnicas
- [ ] **Health Checks** - Endpoints de monitoreo con Spring Actuator
- [ ] **Métricas y Monitoring** - Integración con Prometheus/Grafana
- [ ] **Rate Limiting** - Limitación de peticiones por IP
- [ ] **API Versioning** - Versionado de endpoints

