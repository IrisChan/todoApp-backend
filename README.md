Todo RESTAPI Home Page

## Assumption

- Frontend server runs on <http://localhost:3000>
- RESTAPI server runs on <http://localhost:8080>
- Data is persisted in db in SQl Server

## RESTAPI Deploy
- Create database in SQL Server
- Run `schema.sql` in SQL Management Studio under folder `src/main/resources` to generate the table
- Run `data.sql` to populate some data
- Config jdbc connection in `src/mainresources/application.properties`
- Open Terminal
- Type `./mvnw package`
- Close application that is using port 8080
- Type `java -jar target/demo-0.01-SNAPSHOT.jar`

## Design Pattern
- MVC

## Some Tech
* Sprint boot, Spring JPA
