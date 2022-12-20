FROM openjdk:11
EXPOSE 8080
ADD target/final-project.jar final-project.jar
ENTRYPOINT ["java", "-jar", "final-project.jar"]