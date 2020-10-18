@Library('ised-cicd-lib') _

pipeline {
	agent {
       	label 'maven'
   	}
   	
    options {
        disableConcurrentBuilds()
    }
  
   	environment {
		// GLobal Vars
		IMAGE_NAME = "ClimateSummary"
      
    }
  
    stages {
    	stage('build') {
			steps {
				script{
	    			builder.buildMaven("${IMAGE_NAME}")
				}
			}
    	}
    }
}