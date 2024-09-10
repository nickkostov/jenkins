job('Parallel') {
    scm {
        git {
            remote {
                url('git@github.com:nickkostov/jenkinsfiles.git')
                credentials('git-ecdsa') // Replace 'git-ecdsa' with your Jenkins credential ID
            }
            branch('master')
        }
    }
    steps {
        dsl {
            external('jenkinsfiles/*.groovy')
        }
    }
}