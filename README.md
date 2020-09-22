# ClimateSummary

### INSTRUCTIONS

The following instruction will guide you through the build/deployment/running of the Climate Summary application :

1) Make sure you have following tools installed in your computer
	- Maven (complete setup)
	- JDK 8
2) After checking out the project following steps are taken to clean, package, and run the application
	- Go to command prompt and navigate to the project directory
	- i.e C:\GITHUB-REPOSITORY\ClimateSummary>
	- Give command to clean 
		-C:\GITHUB-REPOSITORY\ClimateSummary>mvn clean
	- Give command to package to generate executable jar file
		-C:\GITHUB-REPOSITORY\ClimateSummary>mvn package
	- To start/run the application perform following steps
		-C:\GITHUB-REPOSITORY\ClimateSummary>cd target		
		-Give the following command to start the application
		-C:\GITHUB-REPOSITORY\ClimateSummary\target>java -jar ClimateSummary-0.0.1-SNAPSHOT.jar

3) To launch application
	- On the browser go to : "localhost:8080/climatesummary" home page
	- Provide dates to filter the search results
	- Click on any of the link on column "Mean Temp" to get to the summary details page

4) For server side validation - steps to reproduce the error
	- Enter any bad URL to replicate error 404
		i.e. http://localhost:8080/climatesummarys
	- Enter following to replicate internal server error (500)
	    i.e. http://localhost:8080/climatedetails/20000

5) What is covered in this project
	- Use of Java, Spring Boot, Sring MVC, Thymeleaf, Maven, Logging framework, Use of CSS, Server side validation

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)


