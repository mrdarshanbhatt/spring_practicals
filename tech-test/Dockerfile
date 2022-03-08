FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/tech-test-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} tech-test.jar
ENTRYPOINT ["java","-jar","/tech-test.jar"]