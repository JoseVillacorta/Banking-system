
# Banking System Microservices Architecture

**Ecosistema bancario completo basado en microservicios, seguridad OAuth2 y programación reactiva.**

Este proyecto simula la arquitectura de un banco moderno, diseñado para ser altamente escalable, resiliente y seguro. Utiliza el ecosistema de **Spring Cloud** para la gestión de la infraestructura y **Spring WebFlux** para un procesamiento de datos eficiente y no bloqueante.

## Descripción del Proyecto

La solución está dividida en microservicios independientes que se comunican entre sí para gestionar clientes, cuentas, transacciones y seguridad. Cada componente ha sido diseñado siguiendo los principios de **Clean Architecture** y **Reactive Programming**.

### Componentes del Sistema
Para más detalles sobre cada módulo, consulta su propia documentación:

- **[Config Server](./ms-config-server/README.md):** Centralización de parámetros.
- **[Registry Service](./registry-service/README.md):** Descubrimiento de servicios con Eureka.
- **[API Gateway](./gateway/README.md):** Punto de entrada único y seguridad perimetral.
- **[OAuth Server](./oauth-server/README.md):** Autorización y autenticación con JWT.
- **[Customer Service](./ms-customer/README.md):** Gestión de identidad de clientes.
- **[Account Service](./ms-account/README.md):** Administración de cuentas bancarias.
- **[Transaction Service](./ms-transaction/README.md):** Registro de movimientos financieros.
- **[Loan Service](./ms-loan/README.md):** Gestión de préstamos e intereses.
- **[Logistics Service](./ms-logistics/README.md):** Optimización de rutas de entrega.
- **[Report Service](./ms-report/README.md):** Generación de documentos y hojas de cobranza.
- **[Config Repository](./banking-config-repo/README.md):** Almacén de archivos de propiedades.

### Tecnologías Core
- **Java 21 & Spring Boot 3.x**
- **Spring Cloud (Gateway, Config, Eureka)**
- **Spring WebFlux & R2DBC** (Stack Reactivo)
- **PostgreSQL** (Bases de datos independientes)
- **Docker & Docker Compose** (Containerización)

---

## Cómo ejecutar el sistema completo

La forma más sencilla de poner en marcha todo el ecosistema es utilizando **Docker Compose**, ya que gestiona las dependencias entre servicios y las bases de datos automáticamente.

### Requisitos previos
- **Docker** y **Docker Compose** instalados.
- Al menos 8GB de RAM disponibles para los contenedores.

### Pasos para el despliegue
1. Clona el repositorio y sitúate en la raíz del proyecto.
2. Compila los proyectos (opcional, el compose lo hará por ti):
   ```bash
   ./gradlew build -x test
   ```
3. Levanta toda la infraestructura y servicios:
   ```bash
   docker-compose up -d
   ```

4. Verifica el estado en el Dashboard de Eureka:
   - `http://localhost:8761`

---

## Arquitectura de Red

El sistema utiliza una red interna de Docker (`banking-network`) para que los servicios se comuniquen de forma segura. El único puerto expuesto al exterior para consumo de APIs es el **8080** (Gateway).

- **Gateway:** `8080`
- **Eureka Dashboard:** `8761`
- **Config Server:** `8888`
- **OAuth Server:** `9000`
