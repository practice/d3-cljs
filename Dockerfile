FROM openjdk:8-alpine

COPY target/uberjar/d3-cljs.jar /d3-cljs/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/d3-cljs/app.jar"]
