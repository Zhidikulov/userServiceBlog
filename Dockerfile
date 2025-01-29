# Базовый образ с Java (например, JDK 17)
FROM amazoncorretto:17

# Установка рабочей директории внутри контейнера
WORKDIR /app

# Копируем JAR-файл в контейнер
COPY target/userServiceBlog-0.0.1-SNAPSHOT.jar app.jar

# Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]

# Открываем порт 8080 (или другой, который использует ваше приложение)
EXPOSE 8080
