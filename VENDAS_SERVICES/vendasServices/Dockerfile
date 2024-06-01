FROM  openjdk:17
ARG JAR_FILE=target/vendasServices-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} vendasServices-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/vendasServices-0.0.1-SNAPSHOT.jar"]