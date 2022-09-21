FROM adoptopenjdk/openjdk11:jre-11.0.10_9-alpine
MAINTAINER francisco.lop.nav@gmail.com
RUN apk update && apk add --no-cache curl
COPY target/*.jar app.jar
CMD java -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar app.jar