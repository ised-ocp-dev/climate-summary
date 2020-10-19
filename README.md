# climate-summary

### INSTRUCTIONS

The following instruction will guide you through the build/deployment/running of the Climate Summary application :

1) Make sure you have following tools installed in your computer
	- Maven (complete setup)
	- JDK 8
2) After cloning the repositiory and checking out the project , please follow following steps to clean and package the jar
	- Go to command prompt and navigate to the repository and project directory
		- i.e C:\GITHUB-REPOSITORY\climate-summary\climate-summary>
			- where GITHUB-REPOSITORY is the repository location and
			- climate-summary is the project directory
	- Give command to clean i.e. C:\GITHUB-REPOSITORY\climate-summary\climate-summary>mvn clean
	- Give command to package to generate executable jar file i.e. C:\GITHUB-REPOSITORY\climate-summary\climate-summary>mvn package
3) To start/run the application perform following steps
	- Go to command prompt and navigate to target directory i.e. C:\GITHUB-REPOSITORY\climate-summary\climate-summary>cd target
	- Give the following command to start the server application
		- C:\GITHUB-REPOSITORY\climate-summary\climate-summary\target>java -jar climate-summary-0.0.1-SNAPSHOT.jar

4) To launch application
	- On the browser go to : "localhost:8080/" home page
	- Provide dates to filter the search results
	- Click on any of the link on column "Mean Temp" to get to the summary details page

5) For server side validation - steps to reproduce the error
	- Enter any bad URL to replicate error 404
		i.e. http://localhost:8080/
	- Enter following to replicate internal server error (500)
	    i.e. http://localhost:8080/climatedetails/20000

6) What is covered in this project
	- Use of Java, Spring Boot, Sring MVC, Thymeleaf, Maven, Unit test, Logging framework, Use of CSS, Client side validation, Server side validation
	
