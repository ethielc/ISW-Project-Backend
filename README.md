Una vez clonado el repositorio, se debe añadir en src/main el directorio "resources", el cual contiene en particular el application.properties
Este último contiene lo siguiente:

spring.jpa.hibernate.ddl-auto = update
spring.datasource.url = jdbc:postgresql://localhost:5432/pabellones
spring.datasource.username = #usuario
spring.datasource.password = #clave
spring.datasource.driver-class-name = org.postgresql.Driver
server.port = #puerto
