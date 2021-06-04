# build stage
FROM gradle:7.0.2-jdk8-hotspot AS build-env

#ARG MAVEN_USER
#ARG MAVEN_PASSWORD
ARG PORT
ARG ARCH

COPY . /src/
#RUN echo "mavenUser=${MAVEN_USER}\nmavenPassword=${MAVEN_PASSWORD}" > /src/gradle.properties
RUN cd /src/ && gradle clean build --warning-mode all
RUN cd /src/app/build/distributions && tar -xvf app.tar
RUN cd /src/app/build/distributions && rm -rf app.tar app.zip
RUN ls -la /src/app/build/distributions/

# final stage
FROM --platform=linux/${ARCH} adoptopenjdk/openjdk8:jre8u292-b10-alpine
WORKDIR /app/
COPY --from=build-env /src/app/build/distributions/app/ /app/
RUN addgroup -S jersey && adduser -S jersey -G jersey && chown -R jersey:jersey /app/
USER jersey
EXPOSE ${PORT}
ENTRYPOINT ["./bin/app"]