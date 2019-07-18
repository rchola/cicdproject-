pipeline {
    agent any
    environment {
        DOCKER_IMAGE_NAME = "cicdproject-docker"
    }
    stages {
        stage('Build') {
            steps {
                echo 'Running build automation'
                sh 'clean install'
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