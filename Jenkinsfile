job('Load Jenkinsfiles') {
    // Set job description
    description('This is a Hello World proof of concept (POC) Jenkins job.')

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

    // Set build triggers (for example, run the job every 15 minutes)
    triggers {
        cron('H/15 * * * *')
    }

    // Add environment variables
    environmentVariables {
        env('GREETING', 'Hello')
        env('TARGET', 'World POC')
    }

    // Add pre-build actions (e.g., cleaning the workspace before building)
    wrappers {
        preBuildCleanup()
    }

    // Define build steps
    steps {
        // Shell step to echo a message
        shell('echo "$GREETING $TARGET"')

    }

    // Add post-build actions (e.g., archiving artifacts)
    // publishers {
    //     archiveArtifacts('**/target/*.jar')
    // }

    // Set up job properties (for example, retention policies)
    logRotator {
        numToKeep(10)       // Keep last 10 builds
        daysToKeep(30)      // Keep builds for 30 days
        artifactNumToKeep(5) // Keep artifacts for last 5 builds
    }
}
