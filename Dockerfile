FROM amazoncorretto:11-alpine-jdk
MAINTAINER HMH
COPY target/hmh-0.0.1-SNAPSHOT.jar  hmh-app.jar
ENTRYPOINT ["java","-jar","/hmh-app.jar"]