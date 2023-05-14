FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} files-manager-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "../target/files-manager-1.0-SNAPSHOT.jar"]
