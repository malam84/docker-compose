FROM java:8
EXPOSE 8084
ADD /target/docker-compose.jar docker-compose.jar
ENTRYPOINT ["java", "-jar", "docker-compose.jar"]