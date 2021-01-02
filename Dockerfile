FROM adoptopenjdk/openjdk11:alpine-jre
LABEL maintainer="sonalisaha14@gmail.com"
COPY build/libs/*.jar menu-store.jar
EXPOSE 4000
ENTRYPOINT ["java","-jar","/menu-store.jar"]