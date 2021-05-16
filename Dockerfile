FROM openjdk:11
COPY "./target/wallet-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 9000
ENTRYPOINT ["java","jar","app.jar"]