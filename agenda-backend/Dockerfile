FROM maven:3.6-jdk-11-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -f pom.xml clean package -DskipTests


FROM openjdk:11

WORKDIR /app

COPY --from=build /workspace/target/*.jar app.jar

ARG db_url
ARG db_database
ARG db_user
ARG db_password


ENV DB_URL=${db_url}
ENV DB_DATABASE=${db_database}
ENV DB_PASSWORD=${db_password}
ENV DB_USER=${db_user}

EXPOSE 8080

CMD [\
    "java", \
    "-Xms128m", \
    "-Xmx256m", \
    "-jar", \
    "app.jar" \
]