pipeline {
    agent any
    tools {
        maven 'Maven 3.6.1'
        jdk 'jdk8'
    }
    stages {
        stage ('Build') {
            steps {
                sh 'mvn clean test' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
    }
}