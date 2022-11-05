
pipeline {
       agent any
        stages{
            stage('Checkout GIT'){
                steps{
                    checkout([$class: 'GitSCM', branches: [[name: '*/youssefback']], extensions: [], userRemoteConfigs: [[credentialsId: '36d256fb-ac53-4780-8300-118e6c67c8bc', url: 'https://github.com/Patsooo/ProjetDevops.git']]])
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

                             







	}

}
