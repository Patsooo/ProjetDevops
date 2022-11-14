pipeline {
    agent any

	
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
        
        
        
        
                    
}

}
