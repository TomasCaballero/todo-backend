# Usa una imagen de Java
FROM openjdk:17
WORKDIR /app

# Copia el JAR generado al contenedor
COPY target/todo-app-backend-0.0.1-SNAPSHOT.jar /app/

# Puerto en el que correrá la app
EXPOSE 8080

# Comando para ejecutar la app
CMD ["java", "-jar", "todo-app-backend-0.0.1-SNAPSHOT.jar"]