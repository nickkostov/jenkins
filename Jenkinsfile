job('Seed') {
    // Set job description
    description('This is a Hello World proof of concept (POC) Jenkins job.')
    keepDependencies(false)
    // Configure the SCM (if the job involves any source control)
    scm {
        git {
            remote {
                url('git@github.com:nickkostov/poc-jenkins.git')
                credentials('git-ecdsa') // Replace with the correct SSH credentials ID
            }
            branch('master')
        }
    }

}