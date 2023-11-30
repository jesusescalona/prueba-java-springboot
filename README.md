# Prueba Java con JWT, H2, Swagger y Diagrama de solución.

- Flujo para el inicio de sesión y el registro del usuario con JWT, Swagger y Diagrama
- Arquitectura API REST de Spring boot y Spring Security

## Proceso de registro, inicio de sesión y autorización del usuario.

![diagrama-solución](diagrama-solución.png)


# Pasos para levantar proyecto
## 1) Instalar dependencias
```
Ubicarse a través de la terminal en la carpeta del proyecto y ejecutar el siguiente comando:

mvn clean install

```
## 2) Ejecutar la aplicación Spring Boot con el siguiente comando
```
mvn spring-boot:run
```

## 3) Acceder a la base de datos h2
```
http://localhost:9090/h2-console/
```

## 4) Ejecuta los siguientes scripts para insertar los roles de usuario para establecer los niveles de acceso
```
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```

## 5) Importar colección Postman para probar servicios:
```
Backend-spring-boot.postman_collection.json
```

## Acceso a swagger
```
http://localhost:9090/doc/swagger-ui/index.html
```

## Clonar repositorio, ejecutar el siguiente comando:
```
git clone https://github.com/jesusescalona/prueba-java-springboot.git
```
