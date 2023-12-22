FROM eclipse-temurin:17-jdk-focal
COPY target/*.jar docker-spring.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "docker-spring.jar"]