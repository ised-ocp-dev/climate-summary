# ClimateSummary

### INSTRUCTIONS

The following instruction will guide you through the build/deployment/running of the Climate Summary application :

1) Make sure you have following tools installed in your computer
	- Maven (complete setup)
	- JDK 8
2) After checking out the project following steps are taken to clean, package, and run the application
	a) Go to command prompt and navigate to the project directory
	b) i.e C:\GITHUB-REPOSITORY\ClimateSummary>
	c) Give command to clean 
		C:\GITHUB-REPOSITORY\ClimateSummary>mvn clean
	d) Give command to package to generate executable jar file
		C:\GITHUB-REPOSITORY\ClimateSummary>mvn package
	c) To start/run the application perform following steps
		C:\GITHUB-REPOSITORY\ClimateSummary>cd target		
		Give the following command to start the application
		C:\GITHUB-REPOSITORY\ClimateSummary\target>java -jar ClimateSummary-0.0.1-SNAPSHOT.jar

3) To launch application
	a) On the browser go to : "localhost:8080/climatesummary" home page
	b) Provide dates to filter the search results
	b) Click on any of the link on column "Mean Temp" to get to the summary details page

4) For server side validation - steps to reproduce the error
	a) Enter any bad URL to replicate error 404
		i.e. http://localhost:8080/climatesummarys
	b) Enter following to replicate internal server error (500)
	    i.e. http://localhost:8080/climatedetails/20000

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)


