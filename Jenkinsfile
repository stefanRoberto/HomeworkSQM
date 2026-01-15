def testFiles = ['CarConstructorTest', 'CarEngineTest', 'CarAccelerationTest', 'CarBrakingTest']

pipeline {
    agent any

    stages {
        stage('Setup Dependencies') {
            steps {
                echo 'Downloading JUnit and Hamcrest...'
                sh '''
                if [ ! -f junit4.jar ]; then
                    curl -O https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar
                    mv junit-4.13.2.jar junit4.jar
                fi
                if [ ! -f hamcrest-core-1.3.jar ]; then
                    curl -O https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar
                fi
                '''
            }
        }

        stage('Compile') {
            steps {
                echo 'Compiling Java files...'
                sh 'javac -cp junit4.jar:. *.java'
            }
        }

        stage('Execute Tests') {
            steps {
                script {
                    for (test in testFiles) {
                        stage("Test: ${test}") {
                            echo "Running ${test}..."
                            sh "java -cp junit4.jar:hamcrest-core-1.3.jar:. org.junit.runner.JUnitCore ${test}"
                        }
                    }
                }
            }
        }
    }
    
    post {
        always {
            echo 'Pipeline execution finished.'
        }
    }
}