FROM java:8-jdk-alpine

COPY ./target/product-app-1.0-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch product-app-1.0-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","product-app-1.0-SNAPSHOT.jar"]