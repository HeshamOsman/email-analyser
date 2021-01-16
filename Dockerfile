FROM maven:3.6.3-openjdk-11
LABEL maintainer="hesham.osman28@gmail.com"

ADD . ~/emailanalyser

EXPOSE 8080

WORKDIR ~/emailanalyser

RUN mvn package

WORKDIR ./target


CMD exec java -jar emailanalyser-0.0.1-SNAPSHOT.jar
