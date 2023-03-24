FROM amazoncorretto:11
MAINTAINER HMH
COPY target/hmh-0.0.1-SNAPSHOT.jar hmh-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/hmh-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080