FROM openjdk:17
EXPOSE 10000
ADD target/dockerbatch5-0.0.1-SNAPSHOT.jar employees.jar
ENTRYPOINT ["java","-jar","/employees.jar"]