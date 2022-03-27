#Concurrency Converter App

###How to run
1) ./mvnw clean package -DskipTests
2) cp .\target\currencyconverter-0.0.1-SNAPSHOT.jar docker/currencycoverter-0.0.1-SNAPSHOT.jar
3) cd .\docker\
4) docker compose up