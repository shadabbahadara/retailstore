Clear README.md that explains how the code and the test can be run and how the
coverage reports can be generated
## How to run the code without IDE
please follow the below steps:  
step 1 : checkout the project from github  
step 2 : install maven 3 in your system and set MAVEN_HOME environment variable  
step 3 : build the project  
mvn clean install  
step 4 : use the generate jar file  

## How to execute the unit tests and generate code coverage report without IDE
please follow the below steps:  
step 1 : checkout the project from github  
step 2 : install maven 3 in your system and set MAVEN_HOME environment variable  
step 3 : execute the below maven command  
mvn clean test  
step 4 : open the below file in you local project directory  
../retailstore/target/site/jacoco/index.html  
