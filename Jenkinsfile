pipeline {
  agent any

  environment {
    DOCKERHUB_CREDENTIALS = credentials('dockerhub-creds')
  }

  stages {
    stage('Checkout') {
      steps {
        git 'https://github.com/AgroConect/agroconnect-backend'
      }
    }

    stage('Build with Maven') {
      steps {
        sh 'mvn clean package -DskipTests'
      }
    }

    stage('Build Docker Image') {
      steps {
        sh 'docker build -t primeford/agroconnect-backend .'
      }
    }

    stage('Push to Docker Hub') {
      steps {
        withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
          sh """
            echo "$PASSWORD" | docker login -u "$USERNAME" --password-stdin
            docker push primeford/agroconnect-backend
          """
        }
      }
    }
  }
}




// pipeline {
//   agent any
//
//   stages {
//     stage('Checkout') {
//       steps {
//         git credentialsId: 'github-token', url: 'https://github.com/AgroConect/agroconnect-backend'
//       }
//     }
//
//     stage('Build') {
//       steps {
//         sh 'mvn clean package -DskipTests'
//       }
//     }
//
//     stage('Build Docker Image') {
//       steps {
//         sh 'docker build -t your-image-name .'
//       }
//     }
//
//     stage('Push to Docker Hub or Azure') {
//       steps {
//         withCredentials([string(credentialsId: 'dockerhub-password', variable: 'DOCKER_PASS')]) {
//           sh '''
//             echo "$DOCKER_PASS" | docker login -u your-dockerhub-username --password-stdin
//             docker push your-image-name
//           '''
//         }
//       }
//     }
//   }
// }

// environment {
//     IMAGE_NAME = "primeford/agroconnect-backend"
//     IMAGE_TAG = "latest"
// }
//
// stages {
//     stage('Checkout Code') {
//         steps {
//             checkout scm
//         }
//     }
//
//     stage('Build JAR') {
//         steps {
//             sh 'mvn clean package -DskipTests'
//         }
//     }
//
//     stage('Build Docker Image') {
//         steps {
//             script {
//                 dockerImage = docker.build("${IMAGE_NAME}:${IMAGE_TAG}")
//             }
//         }
//     }
//
//     stage('Push to DockerHub') {
//         steps {
//             withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
//                 sh """
//                     echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
//                     docker push ${IMAGE_NAME}:${IMAGE_TAG}
//                     docker logout
//                 """
//             }
//         }
//     }
// }
