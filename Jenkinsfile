pipeline {
    agent any

    environment {
        DOCKERHUB_USERNAME = 'primeford'
        IMAGE_NAME = 'primeford/agroconnect-backend'
        DOCKER_CREDENTIALS_ID = 'dockerhub-credentials-id'  // This must match the ID you just created
    }

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/AgroConect/agroconnect-backend.git'
            }
        }

        stage('Build Spring Boot App') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${IMAGE_NAME} ."
            }
        }

        stage('Login to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: "${DOCKER_CREDENTIALS_ID}", usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh 'echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin'
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                sh "docker push ${IMAGE_NAME}"
            }
        }
    }

    post {
        success {
            echo "✅ Backend built, Dockerized, and pushed to Docker Hub."
        }
        failure {
            echo "❌ Build failed. Check the logs."
        }
    }
}
