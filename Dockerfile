# Java 17 JDK slim imajı kullanılacak
FROM openjdk:17-jdk-slim

# Çalışma dizini
WORKDIR /app

# Maven tarafından oluşturulan JAR dosyasını kopyala
COPY target/DressRentalApp-1.0-SNAPSHOT.jar app.jar

# JAR dosyasını çalıştır
ENTRYPOINT ["java", "-jar", "app.jar"]
