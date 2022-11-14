pipeline {
    agent any

	environment {
        registry = "haythemgharbi/devops"
        registryCredential = 'haythem'
        dockerImage = ''
    	}
    stages{
        stage("Git pull stage"){
            steps{
              
                git branch: 'Operateurs',  
                url: 'https://github.com/Patsooo/ProjetDevops.git'
                    
                }
                
            }
            stage('Mvn clean stage') {
                steps {
                sh 'mvn clean'
                    
                }
                
            }
            
        stage('Mvn compile stage') {
                steps {
                sh 'mvn compile'
                    
                }
                
            }
        stage('Mvn package stage'){
                steps{
                sh 'mvn package'
                    
                }
                
            }  
        stage('Mvn test stage') {
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
	post {
        success {
             mail to: "haithemgharbi1920@gmail.com",
                    subject: "Build sucess",
                    body: "sucess"
            echo 'successful'
        }
        failure {
             mail to: "haithemgharbi1920@gmail.com",
                    subject: "Build failed",
                    body: "failed"
            echo 'failed'
        }
      }

}
