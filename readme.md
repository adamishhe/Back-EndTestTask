#Back-End Test Task
###Для реализации проекта использовались:

- H2 data base

- Spring boot

- Spring Data JPA

###Подключение к интерфейсу БД:

- http://localhost:8080/h2-console

- Driver Class: org.h2.Driver
- JDBC URL: jdbc:h2:mem:productdb
- User Name: user
- Password:

application.properties file:

```
server.port=8080
spring.h2.console.enabled=true
#DB
spring.datasource.url=jdbc:h2:mem:productdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=user
spring.datasource.password=
#JPA
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
```

###Выполнение запросов:


Получение товара (Просмотр всех существующих товаров по типу):

(GET-запрос)

- http://localhost:8080/products (возвращает все товары)
- http://localhost:8080/products/hdd (возвращает все жесткие диски)
- http://localhost:8080/products/laptops (возвращает все ноутбуки)
- http://localhost:8080/products/pc (возвращает все ПК)
- http://localhost:8080/products/monitors (возвращает все мониторы)

Просмотр товара по идентификатору:

(GET-запрос)

-http://localhost:8080/products/{id} (возвращает конкретный товар по идентификатору

Добавление товара:

(POST-запрос)

- http://localhost:8080/products/hdd/add (добавляет жесткий диск из тела запроса в БД)
- http://localhost:8080/products/laptops/add (добавляет ноутбук из тела запроса в БД)
- http://localhost:8080/products/pc/add (добавляет ПК из тела запроса в БД)
- http://localhost:8080/products/monitors/add (добавляет монитор из тела запроса в БД)
- Вместо *add* можно использовать *addlist*, чтобы добавить список товаров


Редактирование товара (заменяет только те поля, которые присутствуют в теле запроса):

(PUT-запрос)

- http://localhost:8080/products/hdd/update/{id}
- http://localhost:8080/products/laptops/update/{id}
- http://localhost:8080/products/pc/update/{id}
- http://localhost:8080/products/monitors/update/{id}

Удаление товара:

(DELETE-запрос)

http://localhost:8080/products/{id}


###Для тестирования проекта использовался *Postman*



###Шаблоны тела запроса для добавления товаров:
Hdd:
```
{
        "type": "hdd",
        "serial": "355722",
        "manufacturer": "Toshiba",
        "cost": "100",
        "amount": "38",
        "capacity": "100000"
    },
    {
        "type": "hdd",
        "serial": "934324",
        "manufacturer": "IBM",
        "cost": "300",
        "amount": "5",
        "capacity": "50000"
    }
```

Laptop:

```
{
        "type": "laptop",
        "serial": "2281337",
        "manufacturer": "HP",
        "cost": "300",
        "amount": "10",
        "screenSize": "15"
    },
	{
        "type": "laptop",
        "serial": "234321",
        "manufacturer": "MSI",
        "cost": "500",
        "amount": "3",
        "screenSize": "17"
    }
```

Monitor:

```
{
        "type": "monitor",
        "serial": "77281337",
        "manufacturer": "LG",
        "cost": "150",
        "amount": "15",
        "diagonal": "21"
    },
		{
        "type": "monitor",
        "serial": "944693385",
        "manufacturer": "Xiaomi",
        "cost": "300",
        "amount": "6",
        "diagonal": "17"
    }
```

PC:

```
{
        "type": "pc",
        "serial": "10281337",
        "manufacturer": "Apple",
        "cost": "1000",
        "amount": "20",
        "pcType": "monoblock"
    },
		{
        "type": "pc",
        "serial": "944693385",
        "manufacturer": "Lenovo",
        "cost": "500",
        "amount": "6",
        "pcType": "desktop"
    }
```