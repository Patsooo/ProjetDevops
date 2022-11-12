pipeline {
    agent any
    stages {
        stage('Git Checkout') {
            steps {
                git branch : 'main',
                url : 'https://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@github.com/molka-mrad/SpringAchatProjet.git'
            }
        }
        stage('mvn clean') {
                steps {
                sh 'mvn clean'
                }
                
            }
        stage('mvn compile') {
                steps {
                sh 'mvn compile'  
                }
            }
    }
}
