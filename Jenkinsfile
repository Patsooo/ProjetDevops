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
                sh 'mvn clean'
                }
                
            }
        stage('Unit tests'){
                steps{
                echo 'launching unit tests'
                sh 'mvn test'
                }
            }
        
        stage('Artefact Construction'){
                steps{
                sh 'mvn package -Dmaven.test.skip=true'
                }
            }
        stage('SonarQube stage') {
                steps {
                }
            } 
        stage('Publish to Nexus'){
                steps{
                echo 'deploying ...'
                sh 'mvn deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=1.0 -Dpackaging=jar -Dfile=target/tpAchatProject-1.0.jar -DrepositoryId=deploymentRepo -Durl=http://192.168.56.5:8081/repository/maven-releases/'
                }
            }
        stage('Building image') {
                steps {
                    script{
                        sh 'docker build -t spring .'
                    }
                }
            }
        stage('Deploy image') {
                steps {
                    withDockerRegistry([ credentialsId: "mydocker", url: "https://index.docker.io/v1/" ]){            
                        sh 'docker tag spring molkamrad/spring'
                        sh 'docker push molkamrad/spring'
                    }
                }
            }
         stage('Docker compose') {
          
            steps {
            sh 'docker-compose up -d'
               
            }
        }
          

    }
    post {
        success{
            mail ( body: 'The Spring project pipeline was completed succesfully.', subject: 'Finished Pipeline : Success', to: 'mokamoka678@gmail.com')
        }
        failure{
            mail ( body: 'The Spring project pipeline has failed', subject: 'Finished Pipeline : Failure', to: 'mokamoka678@gmail.com')
        }
    }
}
