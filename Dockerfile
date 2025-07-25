from eucm/maven:latest

workdir /app

copy src /app/src
copy pom.xml /app

RUN mvn clean install

CMD ["java", "-jar", "target/CICD-1.0-SNAPSHOT.jar"]
