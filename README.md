# Prueba Java con JWT, H2, Swagger y Diagrama de solución.

- Flujo para el inicio de sesión y el registro del usuario con JWT, Swagger y Diagrama
- Arquitectura API REST de Spring boot y Spring Security

## Proceso de registro, inicio de sesión y autorización del usuario.

![diagrama-solución](diagrama-solución.png)


## Ejecutar la aplicación Spring Boot con el siguiente comando
```
mvn spring-boot:run
```

## Ejecuta los siguientes scripts para insertar los roles de usuario para establecer los niveles de acceso
```
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```
## Acceso a base de datos h2
```
http://localhost:9090/h2-console/
```
## Acceso a swagger
```
http://localhost:9090/doc/swagger-ui/index.html
```

## Acceso a repositorio, ejecutar siguiente comando:
```
git clone https://github.com/jesusescalona/prueba-spring-boot.git