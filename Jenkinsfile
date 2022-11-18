pipeline {
    agent any
	
environment {
        registry = "dhiya2022/ci"
        registryCredential = 'docker'
        dockerImage = ''
    	}
	
    stages{
        stage("Git pull stage"){
            steps{
              
                git branch: 'dhia-baccari',  
                url: 'https://github.com/Patsooo/ProjetDevops.git'
                    
                }
                
            }
            stage('Mvn clean stage') {
                steps {
                sh 'mvn clean'
                    
                }
                
            }
            
        stage('Mvn compile ') {
                steps {
                sh 'mvn compile'
                    
                }
                
            }
        stage('Mvn package '){
                steps{
                sh 'mvn package'
                    
                }
                
            }  
        stage('Mvn test ') {
                steps {
                sh 'mvn test'
                    
                }
                
            }  
            stage('SonarQube ') {
          
            steps {
            sh'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
               
            }
        } 
        
        stage('Nexus ') {
          
            steps {
           sh 'mvn deploy -e'
               
            }
        }
        
        
       stage('Building  image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
         stage('Deploy  image') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
         stage('Docker compose ') {
          
            steps {
            sh 'docker-compose up -d'
               
            }
        }
       
            
}
	post {
        success {
             mail to: "hammabaccari44@gmail.com",
                    subject: "Build sucess",
                    body: "sucess"
            echo 'successful'
        }
        failure {
             mail to: "hammabaccari44@gmail.com",
                    subject: "Build failed",
                    body: "failed"
            echo 'failed'
        }
      }

}
