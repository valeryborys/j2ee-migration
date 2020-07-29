# j2ee-migration

## Server settings

Download WildFly 9.0.1.Final.

Download mysql-connector-java 5.1.x and it install to Wildfly (see 'modules' folder).

Add to 'standalone.xml' Mysql datasource and mysql driver.

## IDEA settings

Edit Сonfiguration → + JBoss Server → Local.

Add 'j2ee-migration:war' exploded to Deployment.

Server → Application server: path to WildFly

## MySQL settings

Download and install MySQL database. Create 'jm' schema.