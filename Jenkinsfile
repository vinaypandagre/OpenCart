pipeline {
    agent any
    tools {
        jdk 'JDK21'
        maven 'Maven3'
    }
    environment {
        MAVEN_OPTS = '-Xms256m -Xmx1024m'
    }
    stages {
        stage('Checkout') {
            steps { checkout scm }
        }
        stage('Build') {
            steps { sh 'mvn -B clean compile -DskipTests' }
        }
        stage('Run Tests') {
            steps { sh 'mvn -B test -Dheadless=true' }
            post {
                always {
                    junit allowEmptyResults: true, testResults: 'target/surefire-reports/**/*.xml'
                }
            }
        }
        stage('Publish Reports') {
            steps {
                publishHTML([
                    allowMissing: true,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/extent-report',
                    reportFiles: 'index.html',
                    reportName: 'Extent Report'
                ])
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'target/extent-report/**, target/cucumber*.json, target/cucumber-reports*.html', allowEmptyArchive: true
        }
        failure {
            mail to: 'team@example.com',
                 subject: "Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Check details: ${env.BUILD_URL}"
        }
    }
}
