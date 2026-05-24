pipeline {
    agent any
    // docker agent
    /*agent {
        docker {
            image '21-alpine3.23-jdk'
        }
    }*/

    triggers {
        GenericTrigger(
            causeString: 'Triggered by GitHub webhook',
            printPostContent: true,
            printContributedVariables: true
        )
    }


    stages {
        stage('Environment Check') {
            steps {
                sh 'java -version'
                sh 'chmod +x gradlew'
                // on Unix/Linux/MacOS, use the Bourne shell with sh
                //sh 'java -version'
            }
        }
        stage('Clean') {
            steps {
                sh './gradlew clean'
                // on Unix/Linux/MacOS, use the Bourne shell with sh
                // sh './gradlew clean'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew build'
                // on Unix/Linux/MacOS, use the Bourne shell with sh
                // sh './gradlew build'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
                // on Unix/Linux/MacOS, use the Bourne shell with sh
                // sh './gradlew test'
            }
        }
        stage('Checkstyle') {
            steps {
                sh './gradlew checkstyleMain'
                // on Unix/Linux/MacOS, use the Bourne shell with sh
                // sh './gradlew checkstyleMain'
            }
        }
        stage('Shadow Jar') {
            when {
                branch 'main'
            }
            steps {
                sh './gradlew shadowJar'
                // on Unix/Linux/MacOS, use the Bourne shell with sh
                // sh './gradlew shadowJar'
            }
        }
    }

    post {
        always {
            echo 'Build pipeline completed. Check if it was a success or if the build failed'
        }
        failure {
            echo 'Build failed. Please check the logs for details.'
        }
        success {
            echo 'Build succeeded. All tests passed and checkstyle checks are clear.'
        }
    }
}
