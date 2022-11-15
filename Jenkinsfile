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
                sh 'ls target/'
                }
            }
        stage('mvn package'){
                steps{
                sh 'mvn package'
                    
                }
            } 
        stage('docker build') {
                steps {
                    script{
                        sh 'sudo docker build -t spring .'
                    }
                }
            }
        stage('docker push') {
                steps {
                    withDockerRegistry([ credentialsId: "dockerid", url: "https://index.docker.io/v1/" ]){            
                        sh 'docker tag spring molkamrad/spring'
                        sh 'docker push molkamrad/spring'
                    }
                }
            }
          

    }
}
