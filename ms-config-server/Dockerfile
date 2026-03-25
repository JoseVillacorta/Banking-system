# Etapa 1: Construcción
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app

# Copiamos los archivos de Gradle primero
COPY gradlew .
COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .

# Damos permisos y descargamos dependencias
RUN chmod +x ./gradlew
RUN ./gradlew dependencies --no-daemon

# Copiamos el código fuente y compilamos el JAR
COPY src src
RUN ./gradlew build -x test --no-daemon

# Etapa 2: Ejecución
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copiamos solo el archivo JAR final desde la etapa anterior
COPY --from=builder /app/build/libs/*.jar app.jar

# El Config Server corre en el 8888
EXPOSE 8888

# Comando para arrancar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]