# Dashboard backend services

Please refer below steps to run this project.

## Setting up the environment

* Install Java (1.8) and downlaod any latest eclipse version. Configure JDK path in eclipse.
* Install MySql 5.5 or higher

## Import the project to eclipse

Import this project as a Maven project from eclipse.

### Update the DB settings

Update persistence-portal-db.properties file with the MySql user, password (datasource.username, datasource.password)
Also datasource.url , spring.datasource.url

### Clean and build the project

* Right click on pom.xml file -> Run As -> Maven Clean
* Right click on pom.xml file -> Run As -> Maven Install
* Delete if any errors under Problems tab.

### Start the application

Right click on ApiApplication.java -> Run As -> Java Application
