
# Etapa 1: Compilar
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Ejecutar
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 9080
ENV API_URL=http://springboot-app:9082/api/usuarios
ENTRYPOINT ["java", "-jar", "app.jar"]

