FROM maven:3.8-openjdk-17 as builder

ENV TARGET=/home/usr/gelid
RUN mkdir -p $TARGET
WORKDIR $TARGET

COPY . $TARGET

RUN ["mvn", "package", "-DskipTests"]

FROM ubuntu:22.04

RUN ["apt-get", "update"]
RUN ["apt-get", "install", "openjdk-17-jre", "-y", "--no-install-recommends"]

COPY --from=builder /home/usr/gelid/target/gelid-0.0.1.jar /usr/local//gelid/gelid.jar

WORKDIR /usr/local/gelid
CMD ["java","-jar","gelid.jar"]
