FROM maven:3.6.3-jdk-11 AS maven
COPY ./pom.xml ./pom.xml
COPY ./src ./src
COPY ./lib ./lib
RUN mvn clean package install

COPY target/BingoServer-1.0-SNAPSHOT.jar bingoserver.jar
ENTRYPOINT ["java","-jar","/bingoserver.jar"]