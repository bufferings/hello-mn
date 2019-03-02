FROM openjdk:11.0.2-jre-stretch
COPY build/libs/*-all.jar hello-world.jar
CMD java ${JAVA_OPTS} -jar hello-world.jar