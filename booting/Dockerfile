FROM gradle:jdk25-noble AS build
WORKDIR /build
COPY src /build/src
COPY build.gradle.kts /build/build.gradle.kts
COPY settings.gradle.kts /build/settings.gradle.kts
RUN gradle clean build

FROM eclipse-temurin:25-jre-alpine
COPY --from=build /build/build/libs/*.jar /opt/app.jar
#RUN runuser -u postgres -- postgres -c net.ipv4.tcp_keepalives=1 -c net.ipv4.tcp_keepalives_idle=30 -c net.ipv4.tcp_keepalives_count=5 -c net.ipv4.keepalives_interval=10
#COPY script.sh /usr/local/bin/script.sh
#RUN chmod +x /usr/local/bin/script.sh
#RUN /usr/local/bin/script.sh
EXPOSE 8080
ENTRYPOINT exec java -jar /opt/app.jar; tail -f /dev/null