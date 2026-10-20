FROM gradle:jdk25-noble AS build
WORKDIR /build
COPY src /build/src
COPY build.gradle.kts /build/build.gradle.kts
COPY settings.gradle.kts /build/settings.gradle.kts
RUN gradle clean build

FROM eclipse-temurin:25-jre-alpine
COPY --from=build /build/build/libs/*.jar /opt/app.jar
EXPOSE 8080
ENTRYPOINT exec java -jar /opt/app.jar; tail -f /dev/null