
pipeline {
       agent any
        stages{
            stage('Checkout GIT'){
                steps{
                    echo 'Pulling...';
                    git branch: 'youssefback',
                    credentialsId: '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',
                    url : 'https://github.com/Patsooo/ProjetDevops.git';
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
                             







	}

}
