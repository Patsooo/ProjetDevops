pipeline {
    agent any
    stages {
        stage('Git Checkout') {
            steps {
                git branch : 'molka',
                url : 'https://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@github.com/Patsooo/ProjetDevops.git'
            }
        }
        stage('Cleaning') {
                steps {
                echo 'cleaning the project'
                sh 'mvn clean install -U'
                }
                
            }
        stage('Compiling') {
                steps {
                sh 'mvn compile'
                }
            }
        stage('Artefact Construction'){
                steps{
                sh 'mvn package'
                }
            }
        stage('Unit tests'){
                steps{
                echo 'launching unit tests'
                
                }
            }
        stage('Publish to Nexus'){
                steps{
                echo 'deploying ...'
                sh 'mvn deploy:deploy-file -Durl=http://192.168.56.5:8081/repository/maven-releases/'
                }
            }
        stage('SonarQube stage') {
            steps {
            sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=molka2408'
            }
        } 
        stage('Building image') {
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
          

    }
}
