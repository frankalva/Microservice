FROM openjdk:17-alpine

COPY ./target/inventory-0.0.1-SNAPSHOT.jar /

RUN sh -c 'touch inventory-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","/inventory-0.0.1-SNAPSHOT.jar"]

RUN chmod +x /inventory-0.0.1-SNAPSHOT.jar