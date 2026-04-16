
# Banking System Config Server

**Servidor de configuración centralizado para una arquitectura de microservicios bancarios.**

El objetivo principal de este proyecto es gestionar y distribuir todas las configuraciones de los microservicios del sistema (Customer, Account, Transaction, Gateway) desde un único punto, permitiendo cambios en caliente y una gestión eficiente por perfiles (dev, prod, local).

## Descripción del Proyecto

Este microservicio utiliza **Spring Cloud Config** para actuar como un repositorio central de archivos de propiedades (`.yml`). 

### ¿Qué hace esta aplicación?
- Centraliza la configuración de toda la red de microservicios.
- Soporta múltiples entornos a través de perfiles de Spring.
- Ofrece seguridad básica para proteger los datos sensibles de configuración.
- Permite la actualización de propiedades en tiempo de ejecución sin necesidad de reiniciar los servicios consumidores.

### Tecnologías utilizadas
- **Java 21**: Para aprovechar las últimas mejoras de rendimiento y virtual threads.
- **Spring Boot 3.5.x**: El estándar para microservicios Java.
- **Spring Cloud Config Server**: Para la gestión centralizada de archivos.
- **Spring Security**: Para asegurar los endpoints de configuración.

---

## Cómo instalar y ejecutar el proyecto

### Requisitos previos
- **JDK 21** instalado.
- **Docker** (opcional, para ejecución en contenedores).

### Pasos para ejecución con Docker
Si estás usando el `docker-compose.yml` en la raíz del proyecto:
```bash
docker-compose up -d ms-config-server
```

---

## Cómo utilizar el proyecto

Una vez arrancado, el servidor estará disponible en `http://localhost:8888`. 

### Credenciales de acceso
Para que otros microservicios se conecten, deben usar las siguientes credenciales (configuradas en `application-local.yml`):
- **Usuario:** `admin`
- **Contraseña:** `local123`

### Ejemplos de consulta
Puedes verificar si las configuraciones se están cargando correctamente accediendo a estas rutas desde tu navegador o Postman:
- `http://localhost:8888/ms-customer/dev`
- `http://localhost:8888/gateway-service/local`

