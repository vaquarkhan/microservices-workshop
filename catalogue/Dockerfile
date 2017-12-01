FROM openjdk

COPY target/*.jar .

CMD ["java","-jar","catalogue-0.0.1-SNAPSHOT.jar","-Dspring.cloud.consul.host=175.0.0.2"]

