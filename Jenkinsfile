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
                        withCredentials([string(credentialsId: "dockerid", variable : "dockerid")]) {
                            sh 'su docker login -u molkamrad -p ${dockerid}'
                            sh 'su docker build -t molkamrad/dockerr .'
                            sh 'su docker push molkamrad/dockerr'
                        }
                    }
                
                }
            }
    }
}
