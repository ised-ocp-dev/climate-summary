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
		IMAGE_NAME = "climate-summary"
      
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