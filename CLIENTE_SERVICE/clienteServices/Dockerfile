FROM  openjdk:17
ARG JAR_FILE=target/clienteServices-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} clienteServices-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/clienteServices-0.0.1-SNAPSHOT.jar"]