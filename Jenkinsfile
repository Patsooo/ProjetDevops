
pipeline {
       agent any
        stages{
            stage('Checkout GIT'){
                steps{
                    checkout([$class: 'GitSCM', branches: [[name: '*/youssefback']], extensions: [], userRemoteConfigs: [[ url: 'https://github.com/Patsooo/ProjetDevops.git']]])
                             }
	    }

		
stage('MVN CLEAN')
            {
                steps{
                sh  'mvn clean'
                }
            }
            stage('MVN COMPILE')
            {
                steps{
                sh  'mvn compile'
                }
                             }
		stage('MVN PACKAGE'){
		steps{
                              sh  'mvn package'
                          }
                    }
              stage('MVN Test'){
                                              steps{
                                                  sh  'mvn test'
                                              }
	      }
		stage('MVN SONARQUBE ')
                                            {
                                                steps{
                                                sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
                                                }
                                            }
		stage('Mvn deploy ')
                                            {
                                                steps{
                                                 sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false' 
                                                }
                                            }
                             stage('Docker Build and Push') {
       					steps {
         withDockerRegistry([credentialsId: "docker", url: ""]) {
           sh 'printenv'
           sh 'sudo docker build -t devops .'
	   sh 'sudo docker tag devops youssefmansour12/ci:latest'
           sh 'docker push youssefmansour12/ci:latest '
         }
       }
     }







	}

}
