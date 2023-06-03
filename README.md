## Spring / Hibernate / PostgreSQL / log4j / Lombok
### Структура
<img width="261" alt="image" src="https://github.com/egornowik21/java-computer-shop/assets/114665170/64e193ce-6d23-4e55-9e71-8a33e189a1de">

Необходимо реализовать BackEnd сервиса для магазина ноутбуков.
### Требования для запуска
+ В операционной системе должно быть установлено JDK и H2 Database Engine. 
+ Для запуска приложения достаточно открыть у себя на ПК склонированный репозиторий и в application.properties задать свои логин и пароль для базы H2.
+ По умолчанию имя пользователя БД: sa, пароль отсутствует 
+ Также предусмотрено переключение профиля БД на PostgresSQL: spring.profiles.active=devh2 - H2, spring.profiles.active=devpg - PgSQL 

### В приложениии предусмотрена возможность
+ Выводить все товары/производителей - GET
+ Выводить по id товар/производителя - GET
+ Редактировать товар/производителя - PATCH
+ Создавать товар/производителя - POST
+ Удалять  товар/производителя - DELETE

### В Postman проведено тестирование эндпоинтов приложения (entity - Laptop, все остальные идентичны) 
#### GET:
<img width="207" alt="image" src="https://github.com/egornowik21/java-computer-shop/assets/114665170/e6c09a43-4e73-457b-b6a8-c16e2ad2de72">

#### POST:
<img width="207" alt="image" src="https://github.com/egornowik21/java-computer-shop/assets/114665170/2ad265d4-0673-401b-890f-8d22352b0e5c">

#### DELETE:
<img width="207" alt="image" src="https://github.com/egornowik21/java-computer-shop/assets/114665170/e2d843dd-444f-43da-93b4-6ca434fc0c00">

#### PATCH: 
<img width="207" alt="image" src="https://github.com/egornowik21/java-computer-shop/assets/114665170/02e4cd5c-a1fd-4126-941d-a1d09c937d46">


+ Все данные хранятся в БД (предпочтительно Postgres или H2)
+ Наличие текстового логгирования
