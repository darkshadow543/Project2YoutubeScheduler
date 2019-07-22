FROM openjdk:8-jdk-alpine
COPY target/YoutubeScheduler-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "YoutubeScheduler-0.0.1-SNAPSHOT.jar"]