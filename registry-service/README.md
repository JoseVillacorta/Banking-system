
# Banking System Registry Service

**Servidor de descubrimiento de servicios basado en Netflix Eureka.**

El objetivo principal de este proyecto es actuar como un directorio telefónico dinámico para los microservicios. Permite que servicios como `ms-customer` o `ms-account` se encuentren entre sí utilizando nombres lógicos en lugar de direcciones IP estáticas, facilitando el escalado y la comunicación interna.

## Descripción del Proyecto

Este microservicio utiliza **Spring Cloud Netflix Eureka Server** para gestionar el registro y la salud de todas las instancias del sistema bancario.

### Qué hace esta aplicación
- Mantiene un registro actualizado de todos los microservicios activos.
- Permite el balanceo de carga en el lado del cliente (Client-side Load Balancing).
- Monitorea la disponibilidad de los servicios (Heartbeats).
- Facilita la comunicación desacoplada a través del API Gateway.

### Tecnologías utilizadas
- **Java 21**: Para un rendimiento moderno y eficiente.
- **Spring Boot 3.x**: Base del microservicio.
- **Spring Cloud Netflix Eureka Server**: Motor de descubrimiento.
- **Spring Cloud Config Client**: Para obtener su propia configuración de forma remota.

---

## Cómo instalar y ejecutar el proyecto

### Requisitos previos
- **JDK 21** instalado.
- **Config Server** (ms-config-server) debe estar corriendo previamente.

### Pasos para ejecución local (Gradle)
1. Navega a la carpeta del proyecto: `cd registry-service`
2. Ejecuta la aplicación:
   ```bash
   ./gradlew bootRun
   ```

### Pasos para ejecución con Docker
Si utilizas el `docker-compose.yml` principal:
```bash
docker-compose up -d registry-service
```

---

## Cómo utilizar el proyecto

Una vez arrancado, puedes acceder al panel de control (Dashboard) de Eureka para ver qué servicios están registrados y su estado de salud.

### Eureka Dashboard
- **URL:** `http://localhost:8761`

En esta interfaz verás una lista de aplicaciones bajo la columna "Application". Si un microservicio (como MS-CUSTOMER) está corriendo correctamente, aparecerá listado ahí con su estado `UP`.

