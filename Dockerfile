FROM maven:3.5-jdk-8
COPY . /usr/src
WORKDIR /usr/src
RUN mvn clean package -DskipTests

FROM openjdk:8-jre
COPY --from=0 /usr/src/target/rapidscrum-0.0.1-SNAPSHOT.jar /usr/src/app.jar
EXPOSE 8080
WORKDIR /usr/src
CMD java -jar -Dspring.profiles.active=dockerdev  -Djava.net.preferIPv4Stack=true /usr/src/app.jar