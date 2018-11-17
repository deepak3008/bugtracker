# bugtracker
A sample project which integrate the jira into spring boot application and if any exception is incountered in the application then it will automatically add issue to the Jira

This project takes use of spring-boot-aspect-aop.

BugTrackerFactory create instance of active bug tracking profile and register it as spring bean
 
The advice is executed at join point "BugTracking" and "StoryTracking" annotation.

advice prepare the payload and sends it to the instance method addIssue

addIssue method then Convert the payload into either jira or github depending in which profile is active

a rest api call is made to active profile in seperate thread


**Run test case** 
mvn clean test -e

**Run the spring boot application**
mvn spring-boot:run

**Access swagger-ui**

[Access swagger-ui](http://localhost:8080/swagger-ui.html)


 


