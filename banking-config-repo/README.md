# Banking System Configuration Repository

**Almacenamiento centralizado de propiedades para el ecosistema de microservicios.**

Este repositorio contiene todos los archivos de configuración ([.yml](cci:7://file:///d:/Banking-system/docker-compose.yml:0:0-0:0)) que el **ms-config-server** utiliza para alimentar al resto de los microservicios del sistema bancario. 

## Descripción del Proyecto

El uso de un repositorio de configuración independiente permite separar el código fuente de los parámetros de entorno, facilitando la gestión de cambios sin necesidad de recompilar los servicios principales.

### Qué contiene este repositorio
- **application.yml:** Configuraciones comunes compartidas por todos los servicios (ej. logs comunes).
- **gateway-service.yml:** Definición de rutas, filtros y seguridad del API Gateway.
- **ms-customer.yml / ms-account.yml / ms-transaction.yml:** Parámetros específicos de cada servicio, como URLs de base de datos y puertos.
- **registry-service.yml:** Configuraciones para el servidor de descubrimiento Eureka.
- **oauth-server.yml:** Configuración de seguridad, clientes OAuth2 y usuarios.

### Tecnologías relacionadas
- **YAML**: Formato de serialización usado para las propiedades.
- **Spring Cloud Config**: El motor que sirve estos archivos.
- **Git**: Para el control de versiones de las configuraciones.

---

## Cómo utilizar este repositorio

### Integración con el Config Server
Para que el **ms-config-server** pueda leer estos archivos, se debe configurar la propiedad `spring.cloud.config.server.git.uri` apuntando a la ruta de esta carpeta:

```yaml
spring:
  cloud:
    config:
      server:
        git:
          uri: file:///ruta/absoluta/a/banking-config-repo
```

### Actualización de propiedades
- Modifica el archivo YAML correspondiente.
- Guarda los cambios.
- Si el microservicio consumidor tiene activado el endpoint /actuator/refresh, puedes enviarle una petición POST para que cargue los nuevos valores sin reiniciar.

### Estructura de archivos
Los nombres de los archivos deben coincidir con el valor de spring.application.name definido en cada microservicio para que el servidor pueda asociarlos correctamente:

- ms-customer -> lee **ms-customer.yml**
- gateway-service -> lee **gateway-service.yml**
- registry-service -> lee **registry-service.yml**