FROM amazoncorretto:11alpine-jdk
MAINTAINER HMH
COPY hmh-0.0.1-SNAPSHOT.jar hmh-app.jar
ENTRYPOINT ["java","-jar","/hmh-app.jar"]