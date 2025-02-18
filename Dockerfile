# Usa una imagen de Java de Docker Hub
FROM openjdk:21

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR en el contenedor
COPY ./target/todo-app-backend-0.0.1-SNAPSHOT.jar /app/

# Expone el puerto 8080
EXPOSE 8080

# Ejecuta la aplicación
CMD ["java", "-jar", "todo-app-backend-0.0.1-SNAPSHOT.jar"]