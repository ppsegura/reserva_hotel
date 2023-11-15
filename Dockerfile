FROM amazoncorretto:17-alpine-jdk

COPY target/Reserva_Hotel-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar","/app.jar" ]