#FROM maven:3.5.4-jdk-8

#ENV PROJECT_DIR=./docker_file
#RUN mkdir -p $PROJECT_DIR
#WORKDIR $PROJECT_DIR
#ADD ./pom.xml $PROJECT_DIR
#RUN mvn dependency:resolve

#ADD ./src/ $PROJECT_DIR
#RUN mvn install

FROM openjdk:8-jdk
ADD ./target/homework17-1.0-SNAPSHOT.jar .
#ENV $PROJECT_DIR=./docker_file
#RUN mkdir -p $PROJECT_DIR
#WORKDIR $PROJECT_DIR
#COPY --from=0 $PROJECT_DIR/target/ $PROJECT_DIR/

EXPOSE 8080
#EXPOSE 27017


CMD ["java", "-jar", "homework17-1.0-SNAPSHOT.jar"]