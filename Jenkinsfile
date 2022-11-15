pipeline {
    agent any
    stages {
        stage('Git Checkout') {
            steps {
                git branch : 'molka',
                url : 'https://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@github.com/Patsooo/ProjetDevops.git'
            }
        }
        stage('mvn clean') {
                steps {
                sh 'mvn clean'
                sh 'mvn dependency:purge-local-repository clean install -U'
                }
                
            }
        stage('mvn compile') {
                steps {
                sh 'mvn compile'  
                }
            }
        stage('docker build and push') {
                steps {
                    script{
                        sh 'docker build -t molkamrad/dockerr .'
                    }
                }
            }
    }
}
