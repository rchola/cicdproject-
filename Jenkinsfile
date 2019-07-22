pipeline {
    agent any
    tools {
        maven 'mvn'
        jdk 'jdk8'
    }
    environment {
        DOCKER_IMAGE_NAME_HOMOLOG = "cicdproject-docker-homolog"
        DOCKER_IMAGE_NAME_PROD = "cicdproject-docker-prod"
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                    echo "${env}"
                '''
            }
        }
        stage('Clean') {
                steps {
                    echo 'Running build automation'
                    sh 'mvn clean'
                }
            }
        stage('Build') {
            steps {
                echo 'Running build automation'
                sh 'mvn install'
            }
        }
        stage('Build Docker Image Prod') {
            when {
                branch 'master'
            }
            steps {
                script {
                    app = docker.build(DOCKER_IMAGE_NAME_PROD)
                    app.inside {
                        sh 'Compilado producao'
                    }
                }
            }
        }
        stage('Build Docker Image Homolog') {
            when {
                beforeInput true
                branch 'dev'
            }
            steps {
                script {
                    app = docker.build(DOCKER_IMAGE_NAME_HOMOLOG)
                    app.inside {
                        sh 'Compilado dev'
                    }
                }
            }
        }
    }
}