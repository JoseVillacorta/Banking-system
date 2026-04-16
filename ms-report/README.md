
# Banking System Report Microservice

**Microservicio para la generación y exportación de reportes bancarios.**

Este servicio se encarga de consolidar información y presentarla en formatos amigables para el usuario final o el personal de campo. Su funcionalidad principal hoy está centrada en la generación de documentos PDF para la gestión operativa en diferentes zonas geográficas.

## Descripción del Proyecto

El **Report Microservice** utiliza librerías de generación de documentos para transformar datos reactivos en archivos descargables.

### Qué hace esta aplicación
- **Generación de PDF:** Crea reportes dinámicos utilizando la librería OpenPDF.
- **Hojas de Cobranza:** Genera automáticamente la "Hoja de Colección" por `zoneId`, lo que permite al personal descargar un PDF con la lista de pagos pendientes en una zona específica.
- **Integración Reactiva:** Obtiene información de otros microservicios para construir los documentos en tiempo real sin bloquear hilos.

### Tecnologías utilizadas
- **Java 21**
- **Spring Boot 3.x / WebFlux**
- **OpenPDF**: Motor para la creación de archivos PDF.
- **Lombok**
- **Eureka & Config Client**.

---

## Cómo instalar y ejecutar el proyecto

### Requisitos previos
1. **ms-config-server** y **registry-service** deben estar activos.
2. Acceso a los microservicios de origen (ej. `ms-loan` o `ms-logistics`) si el reporte requiere datos externos.

### Pasos para ejecución local (Gradle)
1. Navega a la carpeta: `cd ms-report`
2. Ejecuta:
   ```bash
   ./gradlew bootRun
   ```

### Pasos para ejecución con Docker
```bash
docker-compose up -d ms-report
```

---

## Cómo utilizar el proyecto

### Endpoints (v1)
- **Hoja de Cobranza (PDF):** `GET /api/v1/reports/collection-sheet/{zoneId}`

Al acceder a este endpoint, el servicio procesa los datos de la zona indicada y devuelve un flujo de bytes con el contenido del PDF generado, listo para ser visualizado o descargado en el navegador.
