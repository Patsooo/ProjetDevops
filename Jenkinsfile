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
                        sh 'docker build -t spring .'
                    }
                }
            }
        stage('docker push') {
                steps {
                    withDockerRegistry([ credentialsId: "mydocker", url: "https://index.docker.io/v1/" ]){            
                        sh 'docker tag spring molkamrad/spring'
                        sh 'docker push molkamrad/spring'
                    }
                }
            }
        stage('SonarQube stage') {
            steps {
            sh'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=molka2408'
            }
        } 
          

    }
}
