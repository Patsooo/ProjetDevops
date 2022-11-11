pipeline {
    agent any

	environment {
        registry = "haythemgharbi/devops"
        registryCredential = 'haythem'
        dockerImage = ''
    	}
    stages{
        stage("git pull"){
            steps{
              
                git branch: 'Operateurs',  
                url: 'https://github.com/Patsooo/ProjetDevops.git'
                    
                }
                
            }
            stage('MVN CLEAN') {
                steps {
                sh 'mvn clean'
                    
                }
                
            }
            
        stage('MVN COMPILE') {
                steps {
                sh 'mvn compile'
                    
                }
                
            }
        stage('MVN PACKAGE'){
                steps{
                sh 'mvn package'
                    
                }
                
            }  
        stage('MVN TEST') {
                steps {
                sh 'mvn test'
                    
                }
                
            }  
            stage('SonarQube stage') {
          
            steps {
            sh'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
               
            }
        } 
        
        stage('Nexus stage') {
          
            steps {
           sh 'mvn deploy -e'
               
            }
        }
        
        stage('Building our image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
         stage('Deploy our image') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
        
        stage('Docker compose stage') {
          
            steps {
            sh 'docker-compose up -d'
               
            }
        }
        
        
                    
}

}
