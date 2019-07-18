pipeline {
    agent any
    tools {
        maven 'mvn'
        jdk 'jdk8'
    }
    environment {
        DOCKER_IMAGE_NAME = "cicdproject-docker"
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
        stage('Clean') {
                steps {
                    echo 'Running build automation'
                    sh 'mvn install'
                }
            }
        stage('Build') {
            steps {
                echo 'Running build automation'
                sh 'mvn install'
            }
        }
        stage('Build Docker Image') {
            when {
                branch 'master'
            }
            steps {
                script {
                    app = docker.build(DOCKER_IMAGE_NAME)
                    app.inside {
                        sh 'echo Hello, World!'
                    }
                }
            }
        }


    }
}