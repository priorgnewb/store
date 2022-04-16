## E-STORE Services
Простая панель управления магазином. Администратором ведется контроль количества продуктов и их цен, при этом в базе данных выполняются типовые CRUD-операции.

Используемый стэк: **Java, Spring Boot, PostgreSQL, Docker**

## Запуск приложения c использованием docker-compose
### 1. Сборка .jar файла
После клонирования репозитория выполнить в терминале команду из корня проекта:

`mvn clean package -Dmaven.test.skip`

Переместить `.jar` файл в `store\docker\services\app\`

### 2. Запуск docker-compose
В терминале перейти в директорию с файлом `docker-compose.yml`, собрать Docker-образы и запустить приложение:

`cd docker`

`docker-compose up`

### 3. Тестирование приложения
В браузере приложение доступно по адресу `http://localhost:8092`

## Запуск проекта в IntellijIDEA
### 1. Импорт проекта
После клонирования репозитория импортировать проект в IntellijIDEA

`File -> New -> Project -> From existing sources`

и указать путь к `pom.xml`

В конфигурационном файле приложения `src/main/resources/application.properties` изменить строку подключения к базе данных:

вместо
`spring.datasource.url=jdbc:postgresql://postgres:5432/store`

указать
`spring.datasource.url=jdbc:postgresql://localhost:5432/store`

### 2. Запуск проекта
Запустить приложение `Run -> Run`

### 3. Тестирование приложения
В браузере приложение доступно по адресу `http://localhost:8091`