
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
                             







	}

}
