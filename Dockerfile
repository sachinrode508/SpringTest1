FROM openjdk:8
EXPOSE 8080
ADD target/springtest1.jar springtest1.jar
ENTRYPOINT ["java","-jar","/springtest1.jar"]