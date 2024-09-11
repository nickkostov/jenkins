job('Test Job') {
    scm {
        git {
            remote {
                url('git@github.com:nickkostov/poc-jenkins.git')
                credentials('git-ecdsa') // Replace 'git-ecdsa' with your Jenkins credential ID
            }
            branch('master')
        }
    }
    steps {
        dsl {
            external('Jenkinsfile')
        }
    }
}
