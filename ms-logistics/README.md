
# Banking System Logistics Microservice

**Microservicio para la optimización y gestión de rutas de entrega.**

Este servicio se encarga de la parte operativa física del banco, como la entrega de tarjetas de crédito o documentación a los clientes. Su objetivo principal es organizar y generar rutas logísticas diarias basadas en zonas geográficas para mejorar la eficiencia de los repartos.

## Descripción del Proyecto

El **Logistics Microservice** utiliza algoritmos de organización para agrupar entregas pendientes y generar hojas de ruta para el personal de campo.

### Qué hace esta aplicación
- **Generación de Rutas:** Calcula las rutas diarias optimizadas por `zoneId`.
- **Gestión de Entregas:** (En desarrollo) Seguimiento del estado de envío de productos bancarios.
- **Asignación por Zona:** Integra la información geográfica de los clientes para planificar la logística.
- **Arquitectura Reactiva:** Construido sobre WebFlux para manejar múltiples solicitudes de rutas simultáneamente de forma eficiente.

### Tecnologías utilizadas
- **Java 21**
- **Spring Boot 3.x / WebFlux**
- **Spring Data R2DBC (PostgreSQL)**
- **Lombok**
- **Eureka & Config Client**.

---

## Cómo instalar y ejecutar el proyecto

### Requisitos previos
1. **ms-config-server** y **registry-service** deben estar activos.
2. Base de datos **PostgreSQL** (db_logistics) disponible.

### Pasos para ejecución local (Gradle)
1. Navega a la carpeta: `cd ms-logistics`
2. Ejecuta:
   ```bash
   ./gradlew bootRun
   ```

### Pasos para ejecución con Docker
```bash
docker-compose up -d ms-logistics
```

---

## Cómo utilizar el proyecto

### Endpoints (v1)
- **Generar Ruta Diaria:** `GET /api/v1/logistics/routes/{zoneId}`

Este endpoint devuelve el listado de entregas pendientes organizadas de forma lógica para un repartidor asignado a una zona específica.
