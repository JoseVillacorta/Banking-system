# Banking System Config Repository

**Repositorio centralizado de configuraciones para el ecosistema de microservicios bancarios.**

El objetivo principal de este repositorio es almacenar de forma externa y versionada todos los archivos de propiedades (`.yml`) de los microservicios. Esto permite modificar comportamientos, URLs de bases de datos o niveles de log sin necesidad de recompilar el código fuente de las aplicaciones.

## Descripción del Proyecto

Este repositorio es consumido directamente por el **ms-config-server** mediante el sistema de archivos local o un repositorio Git.

### Qué hace este repositorio
- Almacena la configuración específica de cada entorno (dev, local, prod).
- Centraliza parámetros comunes en `application.yml`.
- Separa la lógica de negocio de la infraestructura y configuración.
- Permite la gestión segura de credenciales y rutas de red.

### Tecnologías relacionadas
- **YAML**: Formato utilizado para las configuraciones por su legibilidad.
- **Spring Cloud Config Server**: El servicio encargado de servir estos archivos al resto de la red.
- **Git**: El motor de versionamiento para llevar un historial de los cambios en la configuración.

---

## Cómo utilizar el proyecto

### Estructura de archivos
Para que el servidor asocie correctamente los archivos, deben seguir el nombre del `spring.application.name` definido en cada microservicio:

- `ms-customer.yml`
- `ms-account.yml`
- `ms-transaction.yml`
- `gateway-service.yml`
- `registry-service.yml`

### Pasos para integrar
1. Asegúrate de que la ruta de este repositorio esté configurada en el microservicio **ms-config-server**.
2. Modifica el archivo deseado y guarda los cambios.
3. Si los microservicios están en ejecución, utiliza el endpoint `/actuator/refresh` para actualizar los cambios sin reiniciar.

---

## Cómo utilizar el proyecto

### Credenciales de acceso (Configuración Local)
Cuando los microservicios se conectan para obtener estos archivos, suelen utilizar las credenciales definidas en el servidor de configuración:
- **Usuario:** `admin`
- **Contraseña:** `local123`

